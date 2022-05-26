package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class YearsItem(

	@Json(name="filter")
	val filter: String? = null,

	@Json(name="nofollow")
	val nofollow: Boolean? = null,

	@Json(name="decade")
	val decade: Int? = null,

	@Json(name="count")
	val count: Int? = null,

	@Json(name="from")
	val from: Int? = null,

	@Json(name="to")
	val to: Int? = null,

	@Json(name="years")
	val years: List<YearsItem?>? = null,

	@Json(name="year")
	val year: Int? = null
)