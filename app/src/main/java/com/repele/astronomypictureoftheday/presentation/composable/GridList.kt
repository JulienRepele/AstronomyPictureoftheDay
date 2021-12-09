package com.repele.astronomypictureoftheday.presentation.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
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
        contentPadding = contentPading,
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
