package com.dzakyadlh.gamestoreapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDetail(
    val shortDescription: String? = null,
    val thumbnail: String? = null,
    val gameUrl: String? = null,
    val releaseDate: String? = null,
    val genre: String? = null,
    val publisher: String? = null,
    val developer: String? = null,
    val id: Int,
    val title: String,
    val platform: String? = null,
    val status: String? = null,
    val screenshots: List<String> = emptyList(),
    val memory: String? = null,
    val os: String? = null,
    val graphics: String? = null,
    val storage: String? = null,
    val processor: String? = null,
    val isFavorite: Boolean = false
) : Parcelable
