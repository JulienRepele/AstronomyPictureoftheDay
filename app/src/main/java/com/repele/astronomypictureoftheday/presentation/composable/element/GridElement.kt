package com.repele.astronomypictureoftheday.presentation.composable.element

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.repele.astronomypictureoftheday.presentation.theme.AstronomyPictureOfTheDayTheme

@Composable
fun GridElement(
    elementTag: String,
    imageUrl: String?,
    title: String,
    modifier: Modifier = Modifier,
    onElementClicked: (String) -> Unit,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = { onElementClicked(elementTag) }
            )
            .clip(RoundedCornerShape(8.dp)),
    ) {
        LoadableImage(
            imageUrl = imageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .height(128.dp),
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0x00000000), Color(0xAA000000))
                    )
                )
        ) {
            Text(
                text = title,
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
            )
        }
    }
}

@Composable
fun Placeholder(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.onSurface
    ) {}
}

@Preview(showBackground = true)
@Composable
fun GridElementPreview() {
    AstronomyPictureOfTheDayTheme {
        GridElement(
            elementTag = "tag",
            imageUrl = "https://apod.nasa.gov/apod/image/2111/LLPegasi_HubbleLodge_960.jpg",
            title = "The Extraordinary Spiral in LL Pegasi"
        ) {}
    }
}
