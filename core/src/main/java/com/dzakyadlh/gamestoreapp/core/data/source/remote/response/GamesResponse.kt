package com.dzakyadlh.gamestoreapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponseItem(

    @field:SerializedName("short_description")
    val shortDescription: String? = null,

    @field:SerializedName("thumbnail")
    val thumbnail: String? = null,

    @field:SerializedName("game_url")
    val gameUrl: String? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("freetogame_profile_url")
    val freetogameProfileUrl: String? = null,

    @field:SerializedName("genre")
    val genre: String? = null,

    @field:SerializedName("publisher")
    val publisher: String? = null,

    @field:SerializedName("developer")
    val developer: String? = null,

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("platform")
    val platform: String? = null
)
