package com.dzakyadlh.gamestoreapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dzakyadlh.gamestoreapp.R

@Composable
fun SmallCard(
    id: String,
    title: String,
    releaseDate: String,
    modifier: Modifier = Modifier,
    thumbnail: String? = null,
    navigateToDetail: (String) -> Unit
) {
    val year = releaseDate.split("-")[0]
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
    ) {
        OutlinedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(80.dp)
                .clickable { navigateToDetail(id) }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = modifier
                        .size(width = 120.dp, height = 80.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 0.dp,
                                bottomEnd = 0.dp,
                                bottomStart = 8.dp
                            )
                        )
                ) {
                    AsyncImage(
                        model = thumbnail ?: R.drawable.ic_launcher_background,
                        contentDescription = title,
                        contentScale = ContentScale.FillHeight,
                        modifier = modifier.fillMaxSize()
                    )
                }
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = modifier
                            .padding(start = 8.dp),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = year,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = modifier.padding(start = 8.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}