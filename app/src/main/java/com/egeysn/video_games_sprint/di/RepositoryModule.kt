package com.egeysn.video_games_sprint.di

import com.egeysn.video_games_sprint.data.repositories.impl.NetworkRepositoryImpl
import com.example.moviedb.data.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideNetworkRepository(networkRepositoryImpl: NetworkRepositoryImpl): NetworkRepository =
        networkRepositoryImpl
}