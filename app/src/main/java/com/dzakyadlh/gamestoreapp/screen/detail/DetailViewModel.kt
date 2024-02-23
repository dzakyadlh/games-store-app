package com.dzakyadlh.gamestoreapp.screen.detail

import androidx.lifecycle.ViewModel
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesUseCase
import kotlinx.coroutines.flow.Flow

class DetailViewModel(private val gamesUseCase: GamesUseCase) : ViewModel() {
    fun getGameDetail(id: Int): Flow<Game> = gamesUseCase.getGameDetail(id)

    fun setFavorite(game: Game, state: Boolean) = gamesUseCase.updateFavorite(game, state)
}