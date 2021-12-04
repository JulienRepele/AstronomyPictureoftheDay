package com.repele.astronomypictureoftheday.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

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
        modifier = modifier.scrollable(
            state = rememberScrollState(),
            orientation = Vertical,
        )
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
                contentScale = ContentScale.Fit,
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
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Justify,
        )
        explanation?.let {
            Text(
                text = it,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun Chips(
    text: String,
    modifier: Modifier = Modifier,
    color: Color? = null,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(percent = 50),
        color = color ?: MaterialTheme.colors.primaryVariant
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp, 4.dp),
            style = MaterialTheme.typography.body2,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChipsPreview() {
    Chips("Dale Cooper")
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