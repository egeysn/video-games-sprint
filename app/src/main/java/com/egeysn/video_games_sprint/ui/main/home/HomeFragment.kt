package com.egeysn.video_games_sprint.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.egeysn.video_games_sprint.adapters.GamesAdapter
import com.egeysn.video_games_sprint.adapters.GamesViewPagerAdapter
import com.egeysn.video_games_sprint.data.generals.ResultsItem
import com.egeysn.video_games_sprint.data.repositories.GamesResponse
import com.egeysn.video_games_sprint.databinding.FragmentHomeBinding
import com.egeysn.video_games_sprint.utils.Resource
import com.egeysn.video_games_sprint.utils.views.ZoomOutPageTransformer
import com.naylalabs.kotlinbaseproject.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment() :
    BaseFragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by activityViewModels()

    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setup()
        setupObservers()
        listeners()
        fetchGames()
        return binding.root
    }

    private fun setup() {
        viewPager2 = binding.viewPager
    }

    private fun fetchGames() {
        viewModel.fetchGames().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
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
        Timber.d("games list fetched")
        val resultList = response.results
        val viewPagerList = resultList.take(3)
        setupViewPager(viewPagerList)
        val subResultList = response.results.slice(2 until resultList.size)
        if (resultList.isNullOrEmpty()) {
            binding.body.visibility = View.GONE
            binding.emptyList.visibility = View.VISIBLE
        } else {
            binding.body.visibility = View.VISIBLE
            binding.emptyList.visibility = View.GONE
            val adapter = GamesAdapter(viewModel, subResultList)
            binding.gamesRv.adapter = adapter
        }
    }

    private fun setupViewPager(resultList: List<ResultsItem>) {
        val viewPagerAdapter = GamesViewPagerAdapter(viewModel, resultList)
        viewPager2.adapter = viewPagerAdapter
        viewPager2.setPageTransformer(ZoomOutPageTransformer())
        viewPager2.setCurrentItem(0, false)
        binding.dotsIndicator.setViewPager2(viewPager2)
    }

    private fun listeners() {
    }

    private fun setupObservers() {
    }
}
