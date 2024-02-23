package com.dzakyadlh.favorite

import androidx.lifecycle.ViewModel
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesUseCase
import kotlinx.coroutines.flow.Flow

class FavoriteViewModel(gamesUseCase: GamesUseCase) : ViewModel() {
    val favorites: Flow<List<Game>> = gamesUseCase.getFavorite()
}