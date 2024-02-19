package com.dzakyadlh.gamestoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dzakyadlh.gamestoreapp.theme.GameStoreAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameStoreAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameStoreApp()
                }
            }
        }
    }
}

//Terdapat 3 Fitur Utama
//Syarat:
//
//Tema dan API yang digunakan bebas.
//Terdapat halaman list item, detail item, dan list favorite (menggunakan database).
//Semua fitur berjalan dengan lancar tanpa ada force close.
//
//Menerapkan Modularization
//Syarat:
//
//Membuat 1 Android Library untuk core dan 1 dynamic feature untuk favorite.
//
//Menerapkan Clean Architecture
//Syarat:
//
//Tidak melanggar dependency rule dari Clean Architecture.
//Memisahkan model untuk domain dengan model untuk data (separation model).
//
//Menerapkan Dependency Injection
//Syarat:
//
//Harus menggunakan library Dependency Injection berikut : Dagger/Hilt/Koin/Kodein (pilih salah satu).
//Menerapkan dengan tepat untuk melakukan injection untuk semua fungsionalitas.
//
//Menerapkan Reactive Programming
//Syarat:
//
//Boleh menggunakan Rx/Flow (pilih salah satu).
//Menerapkan dengan tepat untuk mengambil data dari network dan database.