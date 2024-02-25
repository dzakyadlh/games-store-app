package com.dzakyadlh.favorite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dzakyadlh.favorite.di.favoriteModule
import com.dzakyadlh.favorite.navigation.Screen
import com.dzakyadlh.favorite.ui.theme.GameStoreAppTheme
import com.dzakyadlh.gamestoreapp.screen.detail.DetailScreen
import org.koin.core.context.loadKoinModules

class FavoriteActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        loadKoinModules(favoriteModule)
        setContent {
            GameStoreAppTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = { TopAppBar(navController = navController) },
                        modifier = Modifier
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Favorite.route,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(Screen.Favorite.route) {
                                FavoriteScreen(
                                    navController = navController,
                                    navigateToDetail = { gameId ->
                                        navController.navigate(Screen.Detail.createRoute(gameId))
                                    })
                            }
                            composable(
                                route = Screen.Detail.route,
                                arguments = listOf(navArgument("gameId") { type = NavType.IntType })
                            ) {
                                val gameId = it.arguments?.getInt("gameId") ?: -1L
                                DetailScreen(gameId = gameId.toInt())
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current
    if (currentRoute == Screen.Detail.route) {
        androidx.compose.material3.TopAppBar(
            title = { Text(text = "", style = MaterialTheme.typography.titleMedium) },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Go Back"
                    )
                }
            },
            scrollBehavior = scrollBehavior,
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .shadow(1.dp)
        )
    } else {
        androidx.compose.material3.TopAppBar(
            title = { Text(text = "Favorite Games", style = MaterialTheme.typography.titleMedium) },
            scrollBehavior = scrollBehavior,
            modifier = modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .shadow(1.dp)
        )
    }
}