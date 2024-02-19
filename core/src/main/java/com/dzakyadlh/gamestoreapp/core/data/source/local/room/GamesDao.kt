package com.dzakyadlh.gamestoreapp.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dzakyadlh.gamestoreapp.core.data.source.local.entity.GamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {
    @Query("SELECT * FROM games")
    fun getGames(): Flow<List<GamesEntity>>

    @Query("SELECT * FROM games WHERE id = :id")
    fun getGameDetail(id: Int): Flow<GamesEntity>

    @Query("SELECT * FROM games WHERE isFavorite = 1")
    fun getAllFavorite(): Flow<List<GamesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGames(games: List<GamesEntity>)

    @Update
    fun updateFavorite(game: GamesEntity)
}