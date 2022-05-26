package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class PlatformsItem(

	@Json(name="requirements_ru")
	val requirementsRu: Any? = null,

	@Json(name="requirements_en")
	val requirementsEn: RequirementsEn? = null,

	@Json(name="released_at")
	val releasedAt: String? = null,

	@Json(name="platform")
	val platform: Platform? = null
)