package com.dzakyadlh.gamestoreapp.core.data.source.local

import com.dzakyadlh.gamestoreapp.core.data.source.local.entity.GamesEntity
import com.dzakyadlh.gamestoreapp.core.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gamesDao: GamesDao) {
    fun getGames(): Flow<List<GamesEntity>> = gamesDao.getGames()

    fun getAllFavorite(): Flow<List<GamesEntity>> = gamesDao.getAllFavorite()

    suspend fun addGames(games: List<GamesEntity>) = gamesDao.addGames(games)

    fun updateFavorite(game: GamesEntity, state: Boolean) {
        game.isFavorite = state
        gamesDao.updateFavorite(game)
    }
}