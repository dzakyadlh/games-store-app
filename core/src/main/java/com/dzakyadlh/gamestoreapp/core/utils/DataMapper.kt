package com.dzakyadlh.gamestoreapp.core.utils

import com.dzakyadlh.gamestoreapp.core.data.source.local.entity.GamesEntity
import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GamesResponseItem
import com.dzakyadlh.gamestoreapp.core.domain.model.Game

object DataMapper {
    fun mapResponsesToEntities(input: List<GamesResponseItem>): List<GamesEntity> {
        val gamesList = ArrayList<GamesEntity>()
        input.map {
            val game = GamesEntity(
                id = it.id,
                title = it.title,
                thumbnail = it.thumbnail,
                releaseDate = it.releaseDate.toString(),
                shortDescription = it.shortDescription.toString(),
                gameUrl = it.gameUrl.toString(),
                genre = it.genre.toString(),
                publisher = it.publisher.toString(),
                developer = it.developer.toString(),
                platform = it.platform.toString()
            )
            gamesList.add(game)
        }
        return gamesList
    }

    fun mapEntitiesToDomain(input: List<GamesEntity>): List<Game> =
        input.map {
            Game(
                id = it.id,
                title = it.title,
                thumbnail = it.thumbnail,
                releaseDate = it.releaseDate.toString(),
                shortDescription = it.shortDescription.toString(),
                gameUrl = it.gameUrl.toString(),
                genre = it.genre.toString(),
                publisher = it.publisher.toString(),
                developer = it.developer.toString(),
                platform = it.platform.toString(),
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Game) = GamesEntity(
        id = input.id,
        title = input.title,
        thumbnail = input.thumbnail,
        releaseDate = input.releaseDate.toString(),
        shortDescription = input.shortDescription.toString(),
        gameUrl = input.gameUrl.toString(),
        genre = input.genre.toString(),
        publisher = input.publisher.toString(),
        developer = input.developer.toString(),
        platform = input.platform.toString(),
        isFavorite = input.isFavorite
    )
}