package com.dzakyadlh.gamestoreapp.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
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
    val isFavorite: Boolean = false
) : Parcelable