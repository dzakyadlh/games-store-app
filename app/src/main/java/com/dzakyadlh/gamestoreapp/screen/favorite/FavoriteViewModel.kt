package com.dzakyadlh.gamestoreapp.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesUseCase

class FavoriteViewModel(gamesUseCase: GamesUseCase) : ViewModel() {
    val favorites = gamesUseCase.getFavorite().asLiveData()
}