package com.dzakyadlh.gamestoreapp

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.dzakyadlh.gamestoreapp.navigation.Screen
import com.dzakyadlh.gamestoreapp.screen.detail.DetailScreen
import com.dzakyadlh.gamestoreapp.screen.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameStoreApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    Scaffold(
        topBar = { TopAppBar(navController) },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navigateToDetail = { gameId ->
                    navController.navigate(Screen.Detail.createRoute(gameId))
                })
            }
            composable(Screen.Favorite.route) {
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("gamestoreapp://favorite")
                    )
                )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
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
            title = {
                Text(
                    text = "Free to Play Games",
                    style = MaterialTheme.typography.titleMedium
                )
            },
            actions = {
                IconButton(onClick = { navController.navigate(Screen.Favorite.route) }) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Your Favorite Games"
                    )
                }
            }
        )
    }
}