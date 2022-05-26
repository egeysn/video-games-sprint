package com.egeysn.video_games_sprint.ui.main.favorites

import com.example.moviedb.data.repository.NetworkRepository
import com.naylalabs.kotlinbaseproject.common.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(repository: NetworkRepository) :
    BaseViewModel()
