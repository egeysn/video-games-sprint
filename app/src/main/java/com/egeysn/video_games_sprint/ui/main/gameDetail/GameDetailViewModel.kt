package com.egeysn.video_games_sprint.ui.main.gameDetail

import androidx.lifecycle.LiveData
import com.egeysn.video_games_sprint.common.BaseViewModel
import com.egeysn.video_games_sprint.data.response.GamesResponse
import com.egeysn.video_games_sprint.utils.Resource
import com.example.moviedb.data.repository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(private val repository: NetworkRepository) : BaseViewModel() {

    fun fetchGameDetail(id: String): LiveData<Resource<GamesResponse>> {
        return repository.getGames()
    }
}
