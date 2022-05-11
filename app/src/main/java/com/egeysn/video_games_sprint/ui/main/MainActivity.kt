package com.egeysn.video_games_sprint.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.egeysn.video_games_sprint.adapters.pagerAdapter.HomePagerAdapter
import com.egeysn.video_games_sprint.databinding.ActivityMainBinding
import com.egeysn.video_games_sprint.utils.views.NavigationBar
import com.naylalabs.kotlinbaseproject.common.BaseActivity

@SuppressLint("CustomSplashScreen")
class MainActivity : BaseActivity(), NavigationBar.NavigationBarListener {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private lateinit var pagerAdapter: HomePagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adjustUI()
    }

    private fun adjustUI() {
        viewPager = binding.viewPager

        pagerAdapter = HomePagerAdapter(this)
        viewPager.adapter = pagerAdapter
        viewPager.offscreenPageLimit = 4
        viewPager.isUserInputEnabled = false
        binding.navigation.setListener(this)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                try {
                    binding.navigation.selectItem(position)
                } catch (e: Exception) {
                }
            }
        })
    }

    override fun onNavigationClicked(pos: Int) {
        binding.viewPager.currentItem = pos
    }

    fun changeSelectedTab(pos: Int) {
        viewPager.currentItem = pos
    }

    companion object {
        fun createSimpleIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
