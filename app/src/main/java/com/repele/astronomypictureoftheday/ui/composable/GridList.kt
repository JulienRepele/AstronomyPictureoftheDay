package com.repele.astronomypictureoftheday.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.repele.astronomypictureoftheday.data.MediaType
import com.repele.astronomypictureoftheday.data.PictureOfTheDay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureOfTheDayGrid(
    elements: List<PictureOfTheDay>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier,
    ) {
        items(elements) { element ->
            GridElement(
                elementTag = element.date,
                imageUrl = element.contentUrl,
                modifier = Modifier.padding(4.dp),
                title = element.title,
                onElementClicked = {}
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PictureOfTheDayGridPreview() {
    val elements = listOf(
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            hdImageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
            thumbnailUrl = null,
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            hdImageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
            thumbnailUrl = null,
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            hdImageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
            thumbnailUrl = null,
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            hdImageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
            thumbnailUrl = null,
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            hdImageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
            thumbnailUrl = null,
        )
    )
    PictureOfTheDayGrid(
        elements = elements
    )
}