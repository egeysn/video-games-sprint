package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class Platform(

	@Json(name="image")
	val image: Any? = null,

	@Json(name="games_count")
	val gamesCount: Int? = null,

	@Json(name="year_end")
	val yearEnd: Any? = null,

	@Json(name="year_start")
	val yearStart: Any? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="image_background")
	val imageBackground: String? = null,

	@Json(name="slug")
	val slug: String? = null,

	@Json(name="platform")
	val platform: Int? = null
)