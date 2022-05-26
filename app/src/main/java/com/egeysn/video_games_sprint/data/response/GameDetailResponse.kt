package com.egeysn.video_games_sprint.data.response

import com.egeysn.video_games_sprint.data.generals.*
import com.squareup.moshi.Json

data class GameDetailResponse(

    @Json(name = "added")
    val added: Int? = null,

    @Json(name = "developers")
    val developers: List<DevelopersItem?>? = null,

    @Json(name = "name_original")
    val nameOriginal: String? = null,

    @Json(name = "rating")
    val rating: Double? = null,

    @Json(name = "game_series_count")
    val gameSeriesCount: Int? = null,

    @Json(name = "playtime")
    val playtime: Int? = null,

    @Json(name = "platforms")
    val platforms: List<PlatformsItem?>? = null,

    @Json(name = "rating_top")
    val ratingTop: Int? = null,

    @Json(name = "reviews_text_count")
    val reviewsTextCount: Int? = null,

    @Json(name = "publishers")
    val publishers: List<PublishersItem?>? = null,

    @Json(name = "achievements_count")
    val achievementsCount: Int? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "parent_platforms")
    val parentPlatforms: List<ParentPlatformsItem?>? = null,

    @Json(name = "reddit_name")
    val redditName: String? = null,

    @Json(name = "ratings_count")
    val ratingsCount: Int? = null,

    @Json(name = "slug")
    val slug: String? = null,

    @Json(name = "released")
    val released: String? = null,

    @Json(name = "youtube_count")
    val youtubeCount: Int? = null,

    @Json(name = "movies_count")
    val moviesCount: Int? = null,

    @Json(name = "description_raw")
    val descriptionRaw: String? = null,

    @Json(name = "tags")
    val tags: List<TagsItem?>? = null,

    @Json(name = "background_image")
    val backgroundImage: String? = null,

    @Json(name = "tba")
    val tba: Boolean? = null,

    @Json(name = "dominant_color")
    val dominantColor: String? = null,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "reddit_description")
    val redditDescription: String? = null,

    @Json(name = "reddit_logo")
    val redditLogo: String? = null,

    @Json(name = "updated")
    val updated: String? = null,

    @Json(name = "reviews_count")
    val reviewsCount: Int? = null,

    @Json(name = "metacritic")
    val metacritic: Int? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "metacritic_url")
    val metacriticUrl: String? = null,

    @Json(name = "alternative_names")
    val alternativeNames: List<String?>? = null,

    @Json(name = "parents_count")
    val parentsCount: Int? = null,

    @Json(name = "user_game")
    val userGame: Any? = null,

    @Json(name = "metacritic_platforms")
    val metacriticPlatforms: List<MetacriticPlatformsItem?>? = null,

    @Json(name = "creators_count")
    val creatorsCount: Int? = null,

    @Json(name = "ratings")
    val ratings: List<RatingsItem?>? = null,

    @Json(name = "genres")
    val genres: List<GenresItem?>? = null,

    @Json(name = "saturated_color")
    val saturatedColor: String? = null,

    @Json(name = "added_by_status")
    val addedByStatus: AddedByStatus? = null,

    @Json(name = "reddit_url")
    val redditUrl: String? = null,

    @Json(name = "reddit_count")
    val redditCount: Int? = null,

    @Json(name = "parent_achievements_count")
    val parentAchievementsCount: Int? = null,

    @Json(name = "website")
    val website: String? = null,

    @Json(name = "suggestions_count")
    val suggestionsCount: Int? = null,

    @Json(name = "stores")
    val stores: List<StoresItem?>? = null,

    @Json(name = "additions_count")
    val additionsCount: Int? = null,

    @Json(name = "twitch_count")
    val twitchCount: Int? = null,

    @Json(name = "background_image_additional")
    val backgroundImageAdditional: String? = null,

    @Json(name = "esrb_rating")
    val esrbRating: EsrbRating? = null,

    @Json(name = "screenshots_count")
    val screenshotsCount: Int? = null,

    @Json(name = "reactions")
    val reactions: Reactions? = null,

    @Json(name = "clip")
    val clip: Any? = null
)
