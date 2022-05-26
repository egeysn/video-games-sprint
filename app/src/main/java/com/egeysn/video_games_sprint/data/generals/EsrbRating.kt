package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class EsrbRating(

	@Json(name="name")
	val name: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="slug")
	val slug: String? = null
)