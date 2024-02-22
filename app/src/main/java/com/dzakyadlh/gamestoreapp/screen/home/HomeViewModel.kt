package com.dzakyadlh.gamestoreapp.screen.home

import androidx.lifecycle.ViewModel
import com.dzakyadlh.gamestoreapp.core.data.source.Resource
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel(gamesUseCase: GamesUseCase) : ViewModel() {
    val games: Flow<Resource<List<Game>>> = gamesUseCase.getGames()
}