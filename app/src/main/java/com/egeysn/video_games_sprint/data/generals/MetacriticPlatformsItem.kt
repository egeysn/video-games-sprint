package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class MetacriticPlatformsItem(

	@Json(name="metascore")
	val metascore: Int? = null,

	@Json(name="url")
	val url: String? = null,

	@Json(name="platform")
	val platform: Platform? = null
)