package com.dzakyadlh.gamestoreapp.core.data.source.remote.network

import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GameDetailResponse
import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGames(): GamesResponse

    @GET("game")
    suspend fun getGameDetail(
        @Query("id") id: Int
    ): GameDetailResponse
}