package com.dzakyadlh.gamestoreapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{gameId}") {
        fun createRoute(gameId: String) = "detail/$gameId"
    }

    object Favorite : Screen("favorite")
}