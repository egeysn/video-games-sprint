package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class Filters(

	@Json(name="years")
	val years: List<YearsItem?>? = null
)