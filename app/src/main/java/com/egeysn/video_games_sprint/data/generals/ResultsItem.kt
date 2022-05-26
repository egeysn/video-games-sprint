package com.egeysn.video_games_sprint.data.generals

import com.squareup.moshi.Json

data class ResultsItem(

    @Json(name = "added")
    val added: Int? = null,

    @Json(name = "rating")
    val rating: Double? = null,

    @Json(name = "metacritic")
    val metacritic: Int? = null,

    @Json(name = "playtime")
    val playtime: Int? = null,

    @Json(name = "short_screenshots")
    val shortScreenshots: List<ShortScreenshotsItem?>? = null,

    @Json(name = "platforms")
    val platforms: List<PlatformsItem?>? = null,

    @Json(name = "user_game")
    val userGame: Any? = null,

    @Json(name = "rating_top")
    val ratingTop: Int? = null,

    @Json(name = "reviews_text_count")
    val reviewsTextCount: Int? = null,

    @Json(name = "ratings")
    val ratings: List<RatingsItem?>? = null,

    @Json(name = "genres")
    val genres: List<GenresItem?>? = null,

    @Json(name = "saturated_color")
    val saturatedColor: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "added_by_status")
    val addedByStatus: AddedByStatus? = null,

    @Json(name = "parent_platforms")
    val parentPlatforms: List<ParentPlatformsItem?>? = null,

    @Json(name = "ratings_count")
    val ratingsCount: Int? = null,

    @Json(name = "slug")
    val slug: String? = null,

    @Json(name = "released")
    val released: String? = null,

    @Json(name = "suggestions_count")
    val suggestionsCount: Int? = null,

    @Json(name = "stores")
    val stores: List<StoresItem?>? = null,

    @Json(name = "tags")
    val tags: List<TagsItem?>? = null,

    @Json(name = "background_image")
    val backgroundImage: String? = null,

    @Json(name = "tba")
    val tba: Boolean? = null,

    @Json(name = "dominant_color")
    val dominantColor: String? = null,

    @Json(name = "esrb_rating")
    val esrbRating: EsrbRating? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "updated")
    val updated: String? = null,

    @Json(name = "clip")
    val clip: Any? = null,

    @Json(name = "reviews_count")
    val reviewsCount: Int? = null
)
