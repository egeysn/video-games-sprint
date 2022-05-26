package com.egeysn.video_games_sprint.data.response

import com.egeysn.video_games_sprint.data.generals.Filters
import com.egeysn.video_games_sprint.data.generals.ResultsItem
import com.squareup.moshi.Json

data class GamesResponse(

    @Json(name = "next")
    val next: String? = null,

    @Json(name = "nofollow")
    val nofollow: Boolean? = null,

    @Json(name = "noindex")
    val noindex: Boolean? = null,

    @Json(name = "nofollow_collections")
    val nofollowCollections: List<String?>? = null,

    @Json(name = "previous")
    val previous: Any? = null,

    @Json(name = "count")
    val count: Int? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "seo_h1")
    val seoH1: String? = null,

    @Json(name = "filters")
    val filters: Filters? = null,

    @Json(name = "seo_title")
    val seoTitle: String? = null,

    @Json(name = "seo_description")
    val seoDescription: String? = null,

    @Json(name = "results")
    val results: List<ResultsItem>? = emptyList(),

    @Json(name = "seo_keywords")
    val seoKeywords: String? = null
)
