package com.dzakyadlh.gamestoreapp.core.data.source.remote.network

import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GamesResponseItem
import retrofit2.http.GET

interface ApiService {
    @GET("games")
    suspend fun getGames(): List<GamesResponseItem>
}