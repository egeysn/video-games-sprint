package com.egeysn.video_games_sprint.data.repositories.impl

import androidx.lifecycle.LiveData
import com.egeysn.video_games_sprint.BuildConfig
import com.egeysn.video_games_sprint.data.remote.ApiService
import com.egeysn.video_games_sprint.data.response.GamesResponse
import com.egeysn.video_games_sprint.utils.Resource
import com.egeysn.video_games_sprint.utils.performOperation
import com.example.moviedb.data.repository.NetworkRepository
import com.egeysn.video_games_sprint.common.BaseDataSource
import com.egeysn.video_games_sprint.data.response.GameDetailResponse
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

    override fun getGameDetail(id:Int): LiveData<Resource<GameDetailResponse>> {
        return performOperation {
            getResult {
                apiService.getGameDetail(
                    id,
                    BuildConfig.API_KEY
                )
            }
        }
    }
}
