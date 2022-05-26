package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class PlatformsItem(

	@Json(name="requirements")
	val requirements: Requirements? = null,

	@Json(name="released_at")
	val releasedAt: String? = null,

	@Json(name="platform")
	val platform: Platform? = null
)