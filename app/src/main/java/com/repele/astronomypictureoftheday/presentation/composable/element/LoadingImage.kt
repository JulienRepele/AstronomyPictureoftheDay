package com.repele.astronomypictureoftheday.presentation.composable.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImagePainter
import coil.compose.rememberImagePainter

@Composable
fun LoadingImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        val painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                crossfade(true)
                Placeholder()
            }
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        when (painter.state) {
            is AsyncImagePainter.State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            is AsyncImagePainter.State.Empty -> {}
            else -> {
                Text(
                    text = "An error has occurred",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    }
}
