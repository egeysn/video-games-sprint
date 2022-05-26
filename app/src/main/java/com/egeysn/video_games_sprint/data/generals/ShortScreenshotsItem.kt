package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class ShortScreenshotsItem(

	@Json(name="image")
	val image: String? = null,

	@Json(name="id")
	val id: Int? = null
)