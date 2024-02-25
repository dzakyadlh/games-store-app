package com.dzakyadlh.favorite.navigation

sealed class Screen(val route: String) {
    object Favorite : Screen("favorite")
    object Detail : Screen("detail/{gameId}") {
        fun createRoute(gameId: String) = "detail/$gameId"
    }
}