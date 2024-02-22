package com.dzakyadlh.gamestoreapp.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dzakyadlh.gamestoreapp.core.domain.model.Game

@Composable
fun GameList(
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier,
    games: List<Game> = emptyList()
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState, contentPadding = PaddingValues(top = 24.dp, bottom = 80.dp)) {
        items(items = games, key = { it.id }) { data ->
            SmallCard(
                id = data.id.toString(),
                title = data.title,
                thumbnail = data.thumbnail.toString(),
                releaseDate = data.releaseDate.toString(),
                navigateToDetail = navigateToDetail
            )
        }
    }
}