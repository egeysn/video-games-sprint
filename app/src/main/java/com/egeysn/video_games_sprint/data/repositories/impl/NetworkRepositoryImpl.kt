package com.egeysn.video_games_sprint.data.repositories.impl

import androidx.lifecycle.LiveData
import com.egeysn.video_games_sprint.BuildConfig
import com.egeysn.video_games_sprint.data.remote.ApiService
import com.egeysn.video_games_sprint.data.response.GamesResponse
import com.egeysn.video_games_sprint.utils.Resource
import com.egeysn.video_games_sprint.utils.performOperation
import com.example.moviedb.data.repository.NetworkRepository
import com.naylalabs.kotlinbaseproject.common.BaseDataSource
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Named

class NetworkRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @Named("io") private val ioDispatcher: CoroutineDispatcher
) : NetworkRepository, BaseDataSource() {

    override fun getGames(): LiveData<Resource<GamesResponse>> {
        return performOperation {
            getResult {
                apiService.getGames(
                    BuildConfig.API_KEY
                )
            }
        }
    }
}
