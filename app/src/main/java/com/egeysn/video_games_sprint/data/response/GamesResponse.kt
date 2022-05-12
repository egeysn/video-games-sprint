package com.egeysn.video_games_sprint.data.repositories

import com.egeysn.video_games_sprint.data.generals.ResultsItem

data class GamesResponse(
    val next: String,
    val nofollow: Boolean,
    val noindex: Boolean,
    val nofollowCollections: List<String>,
    val previous: Any,
    val count: Int,
    val description: String,
    val seoH1: String,
    val filters: Filters,
    val seoTitle: String,
    val seoDescription: String,
    val results: List<ResultsItem>,
    val seoKeywords: String
)

data class TagsItem(
    val gamesCount: Int,
    val name: String,
    val language: String,
    val id: Int,
    val imageBackground: String,
    val slug: String
)

data class RatingsItem(
    val count: Int,
    val id: Int,
    val title: String,
    val percent: Double
)

data class Platform(
    val image: Any,
    val gamesCount: Int,
    val yearEnd: Any,
    val yearStart: Int,
    val name: String,
    val id: Int,
    val imageBackground: String,
    val slug: String
)

data class AddedByStatus(
    val owned: Int,
    val beaten: Int,
    val dropped: Int,
    val yet: Int,
    val playing: Int,
    val toplay: Int
)

data class YearsItem(
    val filter: String,
    val nofollow: Boolean,
    val decade: Int,
    val count: Int,
    val from: Int,
    val to: Int,
    val years: List<YearsItem>,
    val year: Int
)

data class Store(
    val gamesCount: Int,
    val domain: String,
    val name: String,
    val id: Int,
    val imageBackground: String,
    val slug: String
)

data class PlatformsItem(
    val requirementsRu: Any,
    val requirementsEn: Any,
    val releasedAt: String,
    val platform: Platform
)

data class GenresItem(
    val gamesCount: Int,
    val name: String,
    val id: Int,
    val imageBackground: String,
    val slug: String
)

data class EsrbRating(
    val name: String,
    val id: Int,
    val slug: String
)

data class RequirementsEn(
    val minimum: String,
    val recommended: String
)

data class RequirementsRu(
    val minimum: String,
    val recommended: String
)

data class Filters(
    val years: List<YearsItem>
)

data class ParentPlatformsItem(
    val platform: Platform
)

data class ShortScreenshotsItem(
    val image: String?,
    val id: Int?
)

data class StoresItem(
    val id: Int?,
    val store: Store?
)
