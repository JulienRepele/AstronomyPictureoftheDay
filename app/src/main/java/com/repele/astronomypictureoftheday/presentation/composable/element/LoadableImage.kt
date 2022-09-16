package com.repele.astronomypictureoftheday.presentation.composable.element

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent

@Composable
fun LoadableImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        model = imageUrl,
        modifier = modifier,
        contentDescription = "",
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.size(20.dp).align(Alignment.Center),
                )
            }
            is AsyncImagePainter.State.Error -> {
                ErrorText(modifier = Modifier.align(Alignment.Center))
            }
            else -> {
                SubcomposeAsyncImageContent(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@Composable
fun ErrorText(modifier: Modifier = Modifier) {
    Text(
        text = "An error has occurred",
        color = MaterialTheme.colorScheme.error,
        modifier = modifier,
    )
}
