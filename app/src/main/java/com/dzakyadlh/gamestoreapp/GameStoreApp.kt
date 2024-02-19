package com.dzakyadlh.gamestoreapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dzakyadlh.gamestoreapp.navigation.NavigationItem
import com.dzakyadlh.gamestoreapp.navigation.Screen
import com.dzakyadlh.gamestoreapp.screen.detail.DetailScreen
import com.dzakyadlh.gamestoreapp.screen.favorite.FavoriteScreen
import com.dzakyadlh.gamestoreapp.screen.home.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameStoreApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = { TopAppBar(navController) },
        bottomBar = { BottomAppBar(navController) },
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
                FavoriteScreen(navigateToDetail = { gameId ->
                    navController.navigate(Screen.Detail.createRoute(gameId))
                })
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("gameId") { type = NavType.StringType })
            ) {
                val gameId = it.arguments?.getString("gameId") ?: -1L
                DetailScreen(gameId = gameId.toString())
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
            title = { Text(text = "") },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    androidx.compose.material3.Icon(
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
    }
}

@Composable
fun BottomAppBar(navController: NavHostController, modifier: Modifier = Modifier) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    if (currentRoute == Screen.Home.route || currentRoute == Screen.Favorite.route) {
        NavigationBar(
            modifier = modifier,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ) {
            val navigationItems = listOf(
                NavigationItem(
                    title = "Home",
                    icon = Icons.Default.Home,
                    screen = Screen.Home
                ),
                NavigationItem(
                    title = "Favorite",
                    icon = Icons.Default.Favorite,
                    screen = Screen.Favorite
                ),
            )
            navigationItems.map { item ->
                NavigationBarItem(
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    })
            }
        }
    }
}