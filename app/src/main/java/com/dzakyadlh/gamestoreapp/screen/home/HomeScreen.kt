package com.dzakyadlh.gamestoreapp.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dzakyadlh.gamestoreapp.components.GameList
import com.dzakyadlh.gamestoreapp.components.LinearLoading
import com.dzakyadlh.gamestoreapp.core.data.source.Resource
import com.dzakyadlh.gamestoreapp.core.domain.model.Game
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (String) -> Unit,
    viewModel: HomeViewModel = koinViewModel(),
) {
    var loading by remember {
        mutableStateOf(false)
    }

    var games by remember { mutableStateOf<Resource<List<Game>>>(Resource.Loading()) }

    LaunchedEffect(key1 = viewModel) {
        viewModel.games.collect { resource ->
            games = resource
            loading = resource is Resource.Loading
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        when (games) {
            is Resource.Loading -> {
                loading = true
            }

            is Resource.Success -> {
                val gamesData = (games as Resource.Success<List<Game>>).data
                GameList(navigateToDetail = navigateToDetail, games = gamesData!!)
            }

            is Resource.Error -> {
                loading = false
            }
        }
        LinearLoading(isLoading = loading, modifier = modifier.align(Alignment.BottomCenter))
    }
}