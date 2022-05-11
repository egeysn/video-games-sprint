package com.egeysn.video_games_sprint.adapters.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.egeysn.video_games_sprint.ui.main.favorites.FavoritesFragment
import com.egeysn.video_games_sprint.ui.main.home.HomeFragment


class HomePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            else -> FavoritesFragment()
        }
    }
}
