package com.egeysn.video_games_sprint.ui.main.home

import androidx.lifecycle.LiveData
import com.egeysn.video_games_sprint.data.response.GamesResponse
import com.egeysn.video_games_sprint.utils.Resource
import com.example.moviedb.data.repository.NetworkRepository
import com.naylalabs.kotlinbaseproject.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(val repository: NetworkRepository) :
    BaseViewModel() {

    fun fetchGames(): LiveData<Resource<GamesResponse>> {
        return repository.getGames()
    }
}
