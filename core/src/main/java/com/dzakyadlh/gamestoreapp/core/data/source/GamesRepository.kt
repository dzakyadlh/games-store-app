package com.dzakyadlh.gamestoreapp.core.data.source

import com.dzakyadlh.gamestoreapp.core.data.source.local.LocalDataSource
import com.dzakyadlh.gamestoreapp.core.data.source.remote.RemoteDataSource
import com.dzakyadlh.gamestoreapp.core.data.source.remote.network.ApiResponse
import com.dzakyadlh.gamestoreapp.core.data.source.remote.response.GamesResponseItem
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import com.dzakyadlh.gamestoreapp.core.domain.repository.IGamesRepository
import com.dzakyadlh.gamestoreapp.core.utils.AppExecutors
import com.dzakyadlh.gamestoreapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GamesRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGamesRepository {
    override fun getGames(): Flow<Resource<List<Game>>> =
        object : NetworkBoundResource<List<Game>, List<GamesResponseItem>>() {
            override fun loadFromDB(): Flow<List<Game>> {
                return localDataSource.getGames().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponseItem>>> =
                remoteDataSource.getGames()

            override suspend fun saveCallResult(data: List<GamesResponseItem>) {
                val gamesList = DataMapper.mapResponsesToEntities(data)
                localDataSource.addGames(gamesList)
            }

            override fun shouldFetch(data: List<Game>?): Boolean = data.isNullOrEmpty()
        }.asFlow()

    override fun getGameDetail(id: Int): Flow<Game> {
        return localDataSource.getGameDetail(id).map {
            DataMapper.mapEntityToDomain(it)
        }
    }

    override fun getFavorite(): Flow<List<Game>> {
        return localDataSource.getAllFavorite().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateFavorite(game: Game, state: Boolean) {
        val gamesEntity = DataMapper.mapDomainToEntity(game)
        appExecutors.diskIO().execute { localDataSource.updateFavorite(gamesEntity, state) }
    }

}