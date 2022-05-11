package com.egeysn.video_games_sprint.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.egeysn.video_games_sprint.R
import com.naylalabs.kotlinbaseproject.common.BaseActivity

@SuppressLint("CustomSplashScreen")
class MainActivity : BaseActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object {
        fun createSimpleIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
