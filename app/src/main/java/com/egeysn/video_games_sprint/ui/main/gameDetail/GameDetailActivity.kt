package com.egeysn.video_games_sprint.ui.main.gameDetail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.egeysn.video_games_sprint.common.BaseActivity
import com.egeysn.video_games_sprint.databinding.ActivityGameDetailBinding

@SuppressLint("CustomSplashScreen")
class GameDetailActivity : BaseActivity() {

    private val viewModel: GameDetailViewModel by viewModels()
    private lateinit var binding: ActivityGameDetailBinding

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adjustUI()
    }

    private fun adjustUI() {
        TODO("Not yet implemented")
    }

    companion object {
        fun createSimpleIntent(context: Context): Intent {
            return Intent(context, GameDetailActivity::class.java)
        }
    }
}
