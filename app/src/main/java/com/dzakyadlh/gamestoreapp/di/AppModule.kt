package com.dzakyadlh.gamestoreapp.di

import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesInteractor
import com.dzakyadlh.gamestoreapp.core.domain.usecase.GamesUseCase
import com.dzakyadlh.gamestoreapp.screen.detail.DetailViewModel
import com.dzakyadlh.gamestoreapp.screen.favorite.FavoriteViewModel
import com.dzakyadlh.gamestoreapp.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<GamesUseCase> { GamesInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
//    viewModel { DetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}