package com.dzakyadlh.gamestoreapp.core.data.source.remote

import android.util.Log
import com.dzakyadlh.gamestoreapp.core.data.source.remote.network.ApiResponse
import com.dzakyadlh.gamestoreapp.core.data.source.remote.network.ApiService
import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GamesResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

class RemoteDataSource(private val apiService: ApiService) {
    suspend fun getGames(): Flow<ApiResponse<List<GamesResponseItem>>> {
        return flow {
            try {
                val response = apiService.getGames()
                if (response.isNotEmpty()) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: HttpException) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}