package com.egeysn.video_games_sprint.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.egeysn.video_games_sprint.adapters.GamesAdapter
import com.egeysn.video_games_sprint.data.repositories.GamesResponse
import com.egeysn.video_games_sprint.databinding.FragmentHomeBinding
import com.egeysn.video_games_sprint.utils.Resource
import com.naylalabs.kotlinbaseproject.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

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
        fetchGames()
        return binding.root
    }

    private fun fetchGames() {
        viewModel.fetchGames().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val gameList = it.data
                    it.data?.let { it1 -> onGamesFetched(it1) }
                    hideLoading()
                }
                Resource.Status.ERROR -> {
                    Timber.e("onError : ${it.message}")
                    hideLoading()
                }
                Resource.Status.LOADING -> {
                    showLoading()
                }
            }
        }
    }

    private fun onGamesFetched(response: GamesResponse) {
        val resultList = response.results
        if (resultList.isNullOrEmpty()) {
            binding.body.visibility = View.GONE
            binding.emptyList.visibility = View.VISIBLE
        } else {
            binding.body.visibility = View.VISIBLE
            binding.emptyList.visibility = View.GONE
            val adapter = GamesAdapter(viewModel)
            binding.gamesRv.adapter = adapter
        }
    }

    private fun listeners() {
    }

    private fun setupObservers() {
    }
}
