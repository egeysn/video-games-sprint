package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class StoresItem(

	@Json(name="id")
	val id: Int? = null,

	@Json(name="store")
	val store: Store? = null
)