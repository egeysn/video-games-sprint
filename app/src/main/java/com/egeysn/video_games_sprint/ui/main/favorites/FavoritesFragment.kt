package com.egeysn.video_games_sprint.ui.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.egeysn.video_games_sprint.databinding.FragmentFavoritesBinding
import com.naylalabs.kotlinbaseproject.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoritesFragment() :
    BaseFragment() {

    private lateinit var binding: FragmentFavoritesBinding
    private val viewModel: FavoritesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        setupObservers()
        listeners()
        return binding.root
    }

    private fun listeners() {
    }

    private fun setupObservers() {
    }

    private fun updateCartInfoBox() {
    }
}
