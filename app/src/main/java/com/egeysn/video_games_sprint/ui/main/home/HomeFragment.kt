package com.egeysn.video_games_sprint.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.egeysn.video_games_sprint.databinding.FragmentHomeBinding
import com.naylalabs.kotlinbaseproject.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment() :
    BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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
