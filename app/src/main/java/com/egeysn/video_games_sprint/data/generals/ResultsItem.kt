package com.egeysn.video_games_sprint.data.generals

import com.egeysn.video_games_sprint.data.repositories.*
import com.egeysn.video_games_sprint.data.response.*


data class ResultsItem(
    val added: Int,
    val rating: Double,
    val metacritic: Int,
    val playtime: Int,
    val shortScreenshots: List<ShortScreenshotsItem>,
    val platforms: List<PlatformsItem>,
    val userGame: Any,
    val ratingTop: Int,
    val reviewsTextCount: Int,
    val ratings: List<RatingsItem>,
    val genres: List<GenresItem>,
    val saturatedColor: String,
    val id: Int,
    val addedByStatus: AddedByStatus,
    val parentPlatforms: List<ParentPlatformsItem>,
    val ratingsCount: Int,
    val slug: String,
    val released: String,
    val suggestionsCount: Int,
    val stores: List<StoresItem>,
    val tags: List<TagsItem>,
    val backgroundImage: String,
    val tba: Boolean,
    val dominantColor: String,
    val esrbRating: EsrbRating,
    val name: String,
    val updated: String,
    val clip: Any,
    val reviewsCount: Int
)