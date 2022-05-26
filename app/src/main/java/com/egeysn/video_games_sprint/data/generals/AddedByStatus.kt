package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class AddedByStatus(

	@Json(name="owned")
	val owned: Int? = null,

	@Json(name="beaten")
	val beaten: Int? = null,

	@Json(name="dropped")
	val dropped: Int? = null,

	@Json(name="yet")
	val yet: Int? = null,

	@Json(name="playing")
	val playing: Int? = null,

	@Json(name="toplay")
	val toplay: Int? = null
)