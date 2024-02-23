package com.dzakyadlh.gamestoreapp.screen.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailScreen(
    gameId: Int,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = koinViewModel()
) {
    var loading by remember {
        mutableStateOf(false)
    }

    val detail = viewModel.getGameDetail(gameId).collectAsState(initial = null).value

    Box(modifier = modifier.fillMaxSize()) {
        if (detail != null) {
            var date = DateFormatter(detail.releaseDate.toString())
            Column(modifier = modifier) {
                AsyncImage(
                    model = detail.thumbnail,
                    contentDescription = detail.title,
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier.fillMaxWidth()
                )
                Column(modifier = modifier.padding(8.dp)) {
                    Row(
                        modifier = modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = detail.title, style = MaterialTheme.typography.titleSmall)
                        IconButton(onClick = {
                            viewModel.setFavorite(
                                game = detail,
                                state = !detail.isFavorite
                            )
                        }) {
                            if (!detail.isFavorite) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Add to Favorite"
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "Remove to Favorite"
                                )
                            }
                        }
                    }
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = detail.shortDescription.toString(),
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = modifier.height(16.dp))
                    Divider()
                    Spacer(modifier = modifier.height(16.dp))
                    GameSpecDisplay(label = "Genre", value = detail.genre.toString())
                    GameSpecDisplay(label = "Developer", value = detail.developer.toString())
                    GameSpecDisplay(label = "Publisher", value = detail.publisher.toString())
                    GameSpecDisplay(label = "Release Date", value = date)
                }
            }
        }
    }
}

fun DateFormatter(date: String): String {
    val splitDate = date.split("-")
    var month = ""
    if (splitDate[1] == "01") month = "January"
    else if (splitDate[1] == "02") month = "February"
    else if (splitDate[1] == "03") month = "March"
    else if (splitDate[1] == "04") month = "April"
    else if (splitDate[1] == "05") month = "May"
    else if (splitDate[1] == "06") month = "June"
    else if (splitDate[1] == "07") month = "July"
    else if (splitDate[1] == "08") month = "August"
    else if (splitDate[1] == "09") month = "September"
    else if (splitDate[1] == "10") month = "October"
    else if (splitDate[1] == "11") month = "November"
    else if (splitDate[1] == "12") month = "Desember"
    else return "-"
    return "${splitDate[2]} $month ${splitDate[0]}"
}

@Composable
fun GameSpecDisplay(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.headlineSmall)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
    }
    Spacer(modifier = modifier.height(8.dp))
}