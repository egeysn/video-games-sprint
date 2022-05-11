package com.egeysn.video_games_sprint.ui.splash

import android.os.Bundle
import com.egeysn.video_games_sprint.R
import com.naylalabs.kotlinbaseproject.common.BaseActivity

class SplashActivity : BaseActivity() {
    private val viewModel: SplashActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showLoading()
    }
}
