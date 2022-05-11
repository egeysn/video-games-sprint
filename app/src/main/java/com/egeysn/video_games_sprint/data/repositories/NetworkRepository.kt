package com.egeysn.video_games_sprint.data.repositories

import com.egeysn.video_games_sprint.BuildConfig
import com.egeysn.video_games_sprint.data.remote.ApiService
import com.egeysn.video_games_sprint.utils.performOperation
import com.naylalabs.kotlinbaseproject.common.BaseDataSource
import javax.inject.Inject


class NetworkRepository @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {

    fun getGames() =
        performOperation {
            getResult {
                apiService.getGames(
                    BuildConfig.API_KEY
                )
            }
        }

}