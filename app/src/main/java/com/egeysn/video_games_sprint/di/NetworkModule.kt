package com.egeysn.video_games_sprint.di

import android.content.Context
import com.egeysn.video_games_sprint.BuildConfig
import com.egeysn.video_games_sprint.data.remote.ApiService
import com.egeysn.video_games_sprint.utils.NetworkUtils
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    @Named("logging")
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }

    @Singleton
    @Provides
    @Named("header")
    fun provideHeaderInterceptor(): Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()
            val newRequest = request.newBuilder()
                .header("Content-Type", "application/json")
                .url(newUrl)
                .method(request.method, request.body)
                .build()
            chain.proceed(newRequest)
        }

    @Singleton
    @Provides
    fun provideAppRetrofit(
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BuildConfig.BASE_URL)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideOkHttpCache(context: Context): Cache =
        Cache(context.cacheDir, (10 * 1024 * 1024).toLong())

    @Singleton
    @Provides
    fun provideOkHttpClient(
        cache: Cache,
        @ApplicationContext appContext: Context,
        @Named("logging") logging: Interceptor,
        @Named("header") header: Interceptor,
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            .connectTimeout(10L, TimeUnit.SECONDS)
            .readTimeout(15000, TimeUnit.SECONDS)
            .writeTimeout(70000, TimeUnit.SECONDS)
            .apply {
                addInterceptor(logging)
//                if (BuildConfig.DEBUG) addInterceptor(OkHttpProfilerInterceptor())
                addInterceptor(header)
            }
        client.cache(cache)
        client.addInterceptor { chain ->
            val request = chain.request()

            var response: Response? = null
            var tryCount = 1
            while (tryCount <= 3) {
                try {
                    response = chain.proceed(request)
                    break
                } catch (e: Exception) {
                    if (!NetworkUtils.isNetworkAvailable(appContext)) {
                        // if no internet, no need to retry
                        throw e
                    }
                    if ("Canceled".equals(e.message, ignoreCase = true)) {
                        // Request canceled, do not retry
                        throw e
                    }
                    if (tryCount >= 3) {
                        // max retry count reached, giving up
                        throw e
                    }

                    try {
                        // sleep delay * try count (e.g. 1st retry after 3000ms, 2nd after 6000ms, etc.)
                        Thread.sleep(3000 * tryCount.toLong())
                    } catch (e1: InterruptedException) {
                        throw RuntimeException(e1)
                    }
                    tryCount++
                }
            }
            response!!
        }

        return client.build()
    }

    @Provides
    @Singleton
    fun provideNetworkService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
