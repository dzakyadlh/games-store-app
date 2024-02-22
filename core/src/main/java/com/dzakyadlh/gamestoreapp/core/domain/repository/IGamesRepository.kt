package com.dzakyadlh.gamestoreapp.core.domain.repository

import com.dzakyadlh.gamestoreapp.core.data.source.Resource
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface IGamesRepository {
    fun getGames(): Flow<Resource<List<Game>>>

//    fun getGameDetail(id: Int): Flow<Resource<GameDetail>>

    fun getFavorite(): Flow<List<Game>>

    fun updateFavorite(game: Game, state: Boolean)
}