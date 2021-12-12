package com.repele.astronomypictureoftheday.presentation.composable.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.repele.astronomypictureoftheday.presentation.PictureDetailViewModel
import com.repele.astronomypictureoftheday.presentation.composable.element.Placeholder
import com.repele.astronomypictureoftheday.presentation.composable.element.Chips

@Composable
fun ScreenPictureDetails(
    pictureViewModel: PictureDetailViewModel = hiltViewModel(),
    pictureID: String,
) {
    val picture by pictureViewModel.pictureDetails.collectAsState(initial = null)
    remember {
        pictureViewModel.loadPicture(pictureID)
        true
    }

    PictureDetails(
        title = picture?.title ?: "",
        date = picture?.date ?: "",
        imageUrl = picture?.contentUrl ?: "",
        explanation = picture?.explanation ?: "",
        copyright = picture?.copyright
    )
}

@Composable
fun PictureDetails(
    title: String,
    date: String,
    imageUrl: String,
    modifier: Modifier = Modifier,
    explanation: String? = null,
    copyright: String? = null,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(0.dp, 0.dp, 0.dp, 16.dp)
            .background(MaterialTheme.colorScheme.background),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        ) {
            Image(
                painter = rememberImagePainter(
                    data = imageUrl,
                    builder = {
                        crossfade(true)
                        Placeholder()
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop,
            )
            copyright?.let {
                Chips(
                    text = it,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(16.dp),
                )
            }
        }
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )
        explanation?.let {
            Text(
                text = it,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Justify,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PictureDetailsPreview() {
    PictureDetails(
        title = "At the Shadow's Edge",
        date = "2021-11-25",
        imageUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-small.jpg",
        explanation = "Shaped like a cone tapering into space, the Earth's dark central shadow or umbra has a circular cross-section. It's wider than the Moon at the distance of the Moon's orbit though. But during the lunar eclipse of November 18/19, part of the Moon remained just outside the umbral shadow. The successive pictures in this composite of 5 images from that almost total lunar eclipse were taken over a period of about 1.5 hours. The series is aligned to trace part of the cross-section's circular arc, with the central image at maximum eclipse. It shows a bright, thin sliver of the lunar disk still beyond the shadow's curved edge. Of course, even within the shadow the Moon's surface is not completely dark, reflecting the reddish hues of filtered sunlight scattered into the shadow by Earth's atmosphere.   Notable APOD Submissions: Lunar Eclipse of 2021 November 19",
        copyright = "Jean-Francois Gout"
    )
}
