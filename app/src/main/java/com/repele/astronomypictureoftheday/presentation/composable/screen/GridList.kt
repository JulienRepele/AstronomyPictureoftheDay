package com.repele.astronomypictureoftheday.presentation.composable.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.repele.astronomypictureoftheday.data.MediaType
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.presentation.PituresViewModel
import com.repele.astronomypictureoftheday.presentation.composable.element.GridElement
import com.repele.astronomypictureoftheday.presentation.composable.element.LoadingChips
import kotlinx.coroutines.flow.flowOf

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ScreenPictureOfTheDay(
    pituresViewModel: PituresViewModel = hiltViewModel(),
    navigateToDetails: (String) -> Unit,
) {

    val lazyElements: LazyPagingItems<PictureOfTheDay> = pituresViewModel.pictures.collectAsLazyPagingItems()
    val displayLoading by pituresViewModel.loading.collectAsState()
    val displayError by pituresViewModel.error.collectAsState(initial = false)

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        PictureOfTheDayGrid(
            elements = lazyElements,
            modifier = Modifier.fillMaxSize(),
            onItemClicked = navigateToDetails,
            onNotLoading = { pituresViewModel.onNotLoading() },
            onLoading = { pituresViewModel.onLoading() },
            onError = { pituresViewModel.onError() }
        )

        AppearAnimation(
            visible = displayLoading,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            LoadingChips(text = "Loading")
        }

        AppearAnimation(
            visible = displayError,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            LoadingChips(text = "Loading")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PictureOfTheDayGrid(
    elements: LazyPagingItems<PictureOfTheDay>,
    modifier: Modifier = Modifier,
    onItemClicked: (String) -> Unit,
    onNotLoading: () -> Unit,
    onLoading: () -> Unit,
    onError: () -> Unit,
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = modifier.background(MaterialTheme.colorScheme.background),
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
                loadState.append is LoadState.Loading -> {
                    onLoading()
                }
                loadState.prepend is LoadState.Loading -> {
                    onLoading()
                }
                loadState.refresh is LoadState.Loading -> {
                    onLoading()
                }

                loadState.refresh is LoadState.NotLoading -> {
                    onNotLoading()
                }

                loadState.append is LoadState.Error -> {
                    onError()
                }
                loadState.prepend is LoadState.Error -> {
                    onError()
                }
                loadState.refresh is LoadState.Error -> {
                    onError()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
private fun AppearAnimation(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable AnimatedVisibilityScope.() -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            // Start the slide from 40 (pixels) below where the content is supposed to go, to
            // produce a parallax effect
            initialOffsetY = { 40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = shrinkVertically() + fadeOut(),
        modifier = modifier,
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun PictureOfTheDayGridPreview() {
    // Preview is still not visible with Paging : https://issuetracker.google.com/issues/194544557
    val elements = mockElements.collectAsLazyPagingItems()
    PictureOfTheDayGrid(
        elements = elements,
        onItemClicked = {},
        onNotLoading = {},
        onLoading = {},
        onError = {},
    )
}

private val mockElements = flowOf(
    PagingData.from(
        listOf(
            PictureOfTheDay(
                date = "2021-11-25",
                mediaType = MediaType.IMAGE,
                title = "At the Shadow's Edge",
                explanation = "explanation",
                contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
                thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
                copyright = "Dale Cooper",
            ),
            PictureOfTheDay(
                date = "2021-11-25",
                mediaType = MediaType.IMAGE,
                title = "At the Shadow's Edge",
                explanation = "explanation",
                contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
                thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
                copyright = "Dale Cooper",
            ),
            PictureOfTheDay(
                date = "2021-11-25",
                mediaType = MediaType.IMAGE,
                title = "At the Shadow's Edge",
                explanation = "explanation",
                contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
                thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
                copyright = "Dale Cooper",
            ),
            PictureOfTheDay(
                date = "2021-11-25",
                mediaType = MediaType.IMAGE,
                title = "At the Shadow's Edge",
                explanation = "explanation",
                contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
                thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
                copyright = "Dale Cooper",
            ),
            PictureOfTheDay(
                date = "2021-11-25",
                mediaType = MediaType.IMAGE,
                title = "At the Shadow's Edge",
                explanation = "explanation",
                contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
                thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
                copyright = "Dale Cooper",
            ),
        )
    )
)
