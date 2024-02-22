package com.dzakyadlh.gamestoreapp

import android.app.Application
import com.dzakyadlh.gamestoreapp.core.di.databaseModule
import com.dzakyadlh.gamestoreapp.core.di.networkModule
import com.dzakyadlh.gamestoreapp.core.di.repositoryModule
import com.dzakyadlh.gamestoreapp.di.useCaseModule
import com.dzakyadlh.gamestoreapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class GameStoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@GameStoreApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}