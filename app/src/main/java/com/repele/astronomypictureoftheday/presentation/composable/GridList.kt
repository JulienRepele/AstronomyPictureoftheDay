package com.repele.astronomypictureoftheday.presentation.composable

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.repele.astronomypictureoftheday.data.MediaType
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.presentation.PituresViewModel

@Composable
fun ScreenPictureOfTheDay(
    navController: NavController,
    pituresViewModel: PituresViewModel = hiltViewModel(),
    contentPading: PaddingValues,
) {

    val lazyElements: LazyPagingItems<PictureOfTheDay> = pituresViewModel.pictures.collectAsLazyPagingItems()

    PictureOfTheDayGrid(
        elements = lazyElements,
        onItemClicked = { navController.navigate("picture_details") },
        contentPading = contentPading,
    )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureOfTheDayGrid(
    elements: LazyPagingItems<PictureOfTheDay>,
    modifier: Modifier = Modifier,
    contentPading: PaddingValues,
    onItemClicked: (String) -> Unit,
) {

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = contentPading, //PaddingValues(4.dp),
        modifier = modifier,
    ) {
        items(elements.itemCount) { index ->
            elements[index]?.let { element ->
                GridElement(
                    elementTag = element.date,
                    imageUrl = element.thumbnailUrl,
                    modifier = Modifier.padding(4.dp),
                    title = element.title,
                    onElementClicked = onItemClicked
                )
            }
        }

        elements.apply {
            when {
                loadState.refresh is LoadState.Loading -> {}
                loadState.append is LoadState.Loading -> {}
                loadState.append is LoadState.Error -> {}
            }
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun PictureOfTheDayGridPreview() {
//    mockElements
//    PictureOfTheDayGrid(
//        elements = mockElements,
//        contentPading = PaddingValues(4.dp)
//    ) {}
//}
//
//private val mockElements = listOf(
//    PictureOfTheDay(
//        date = "2021-11-25",
//        mediaType = MediaType.IMAGE,
//        title = "At the Shadow's Edge",
//        explanation = "explanation",
//        contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
//        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
//    ),
//    PictureOfTheDay(
//        date = "2021-11-25",
//        mediaType = MediaType.IMAGE,
//        title = "At the Shadow's Edge",
//        explanation = "explanation",
//        contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
//        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
//    ),
//    PictureOfTheDay(
//        date = "2021-11-25",
//        mediaType = MediaType.IMAGE,
//        title = "At the Shadow's Edge",
//        explanation = "explanation",
//        contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
//        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
//    ),
//    PictureOfTheDay(
//        date = "2021-11-25",
//        mediaType = MediaType.IMAGE,
//        title = "At the Shadow's Edge",
//        explanation = "explanation",
//        contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
//        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
//    ),
//    PictureOfTheDay(
//        date = "2021-11-25",
//        mediaType = MediaType.IMAGE,
//        title = "At the Shadow's Edge",
//        explanation = "explanation",
//        contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
//        thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
//    )
//)