package com.egeysn.video_games_sprint.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import com.egeysn.video_games_sprint.R
import com.egeysn.video_games_sprint.ui.main.MainActivity
import com.naylalabs.kotlinbaseproject.common.BaseActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private val viewModel: SplashActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        waitAndNavigate()
    }

    private fun waitAndNavigate() {
        showLoading()
        Thread.sleep(1000)
        startActivity(MainActivity.createSimpleIntent(this))
    }
}
