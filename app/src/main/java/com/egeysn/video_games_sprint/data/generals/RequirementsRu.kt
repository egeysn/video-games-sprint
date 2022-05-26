package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class RequirementsRu(

	@Json(name="minimum")
	val minimum: String? = null,

	@Json(name="recommended")
	val recommended: String? = null
)