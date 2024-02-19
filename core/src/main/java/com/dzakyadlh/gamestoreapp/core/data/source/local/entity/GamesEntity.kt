package com.dzakyadlh.gamestoreapp.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GamesEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "thumbnail")
    var thumbnail: String? = null,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String? = null,

    @ColumnInfo(name = "shortDescription")
    val shortDescription: String? = null,

    @ColumnInfo(name = "gameUrl")
    val gameUrl: String? = null,

    @ColumnInfo(name = "genre")
    val genre: String? = null,

    @ColumnInfo(name = "publisher")
    val publisher: String? = null,

    @ColumnInfo(name = "developer")
    val developer: String? = null,

    @ColumnInfo(name = "platform")
    val platform: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
