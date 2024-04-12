package com.example.themovieapp.presentation.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.themovieapp.R
import com.example.themovieapp.data.source.remote.MoviesApi
import com.example.themovieapp.utils.toDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewCard(
    name: String,
    content: String,
    photo: String,
    modifier: Modifier = Modifier,
    moreMovieDetails: () -> Unit
) {
    Card(
        modifier = modifier
            .width(400.dp)
            .height(300.dp)
            .padding(10.dp)
            .verticalScroll(ScrollState(1)),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        onClick = moreMovieDetails,
    ) {


        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(MoviesApi.IMAGE_BASE_URL.plus(photo))
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.person),
            contentScale = ContentScale.Crop,
                contentDescription = "hello",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
            )
            Text(
                text = name, style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(start = 10.dp)
            )
        }
            Text(
                text = content,
                modifier = modifier.padding(start = 10.dp)
            )
        }

    }
}