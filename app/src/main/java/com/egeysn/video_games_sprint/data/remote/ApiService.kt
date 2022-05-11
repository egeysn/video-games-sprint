package com.egeysn.video_games_sprint.data.remote

import com.egeysn.video_games_sprint.data.repositories.GamesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
    ): Response<GamesResponse>
}
