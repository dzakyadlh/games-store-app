package com.dzakyadlh.gamestoreapp.core.domain.usecase

import com.dzakyadlh.gamestoreapp.core.data.source.Resource
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.model.GameDetail
import com.dzakyadlh.gamestoreapp.core.domain.repository.IGamesRepository
import kotlinx.coroutines.flow.Flow

class GamesInteractor(private val gamesRepository: IGamesRepository) : GamesUseCase {
    override fun getGames(): Flow<Resource<List<Game>>> = gamesRepository.getGames()

    override fun getGameDetail(id: Int): Flow<Resource<GameDetail>> =
        gamesRepository.getGameDetail(id)

    override fun getFavorite(): Flow<List<Game>> = gamesRepository.getFavorite()

    override fun updateFavorite(game: Game, state: Boolean) =
        gamesRepository.updateFavorite(game, state)

}