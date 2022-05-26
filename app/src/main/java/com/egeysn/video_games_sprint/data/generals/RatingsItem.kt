package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class RatingsItem(

    @Json(name = "count")
    val count: Int? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "percent")
    val percent: Double? = null
)
