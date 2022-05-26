package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class Store(

	@Json(name="games_count")
	val gamesCount: Int? = null,

	@Json(name="domain")
	val domain: String? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="image_background")
	val imageBackground: String? = null,

	@Json(name="slug")
	val slug: String? = null
)