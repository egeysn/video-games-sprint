package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class ParentPlatformsItem(

	@Json(name="platform")
	val platform: Platform? = null
)