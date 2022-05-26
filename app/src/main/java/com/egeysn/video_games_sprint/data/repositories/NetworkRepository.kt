package com.example.moviedb.data.repository

import androidx.lifecycle.LiveData
import com.egeysn.video_games_sprint.data.response.GamesResponse
import com.egeysn.video_games_sprint.utils.Resource


interface NetworkRepository {

    fun getGames(): LiveData<Resource<GamesResponse>>
}
