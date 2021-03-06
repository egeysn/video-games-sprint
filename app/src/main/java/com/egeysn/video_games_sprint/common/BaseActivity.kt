package com.naylalabs.kotlinbaseproject.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.egeysn.video_games_sprint.utils.LoadingHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {


    private lateinit var loadingHelper: LoadingHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadingHelper = LoadingHelper.getInstance(this@BaseActivity)
    }

    fun showLoading() {
        runOnUiThread {
            loadingHelper.showDialog()
        }
    }

    fun hideLoading() {
        runOnUiThread { loadingHelper.hideDialog() }
    }
}
