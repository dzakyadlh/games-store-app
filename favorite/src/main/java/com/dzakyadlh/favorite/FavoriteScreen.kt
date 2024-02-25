package com.dzakyadlh.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dzakyadlh.gamestoreapp.components.GameList
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: FavoriteViewModel = koinViewModel(),
    navigateToDetail: (String) -> Unit,
) {

    val favorites = viewModel.favorites.collectAsState(initial = null).value

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        if (favorites != null) {
            GameList(navigateToDetail = navigateToDetail, games = favorites)
        } else {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "You don't have any favorite games",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}