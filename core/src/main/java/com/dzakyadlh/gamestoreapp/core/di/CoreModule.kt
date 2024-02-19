package com.dzakyadlh.gamestoreapp.core.di

import androidx.room.Room
import com.dzakyadlh.gamestoreapp.core.data.source.GamesRepository
import com.dzakyadlh.gamestoreapp.core.data.source.local.LocalDataSource
import com.dzakyadlh.gamestoreapp.core.data.source.local.room.GamesDatabase
import com.dzakyadlh.gamestoreapp.core.data.source.remote.RemoteDataSource
import com.dzakyadlh.gamestoreapp.core.data.source.remote.network.ApiService
import com.dzakyadlh.gamestoreapp.core.domain.repository.IGamesRepository
import com.dzakyadlh.gamestoreapp.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<GamesDatabase>().favoriteDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GamesDatabase::class.java, "Games.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.freetogame.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IGamesRepository> {
        GamesRepository(
            get(),
            get(),
            get()
        )
    }
}