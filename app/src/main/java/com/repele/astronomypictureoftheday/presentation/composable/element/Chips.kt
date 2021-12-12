package com.repele.astronomypictureoftheday.presentation.composable.element

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingChips(
    text: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(percent = 50),
        color = MaterialTheme.colorScheme.tertiaryContainer
    ) {
        Row {
            Text(
                text = text,
                modifier = Modifier
                    .padding(16.dp, 4.dp, 8.dp, 4.dp)
                    .align(Alignment.CenterVertically),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            CircularProgressIndicator(
                modifier = Modifier
                    .padding(8.dp, 4.dp)
                    .scale(0.75f)
                    .align(Alignment.CenterVertically),
                color = MaterialTheme.colorScheme.onTertiaryContainer,
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
        color = color ?: MaterialTheme.colorScheme.surface
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp, 4.dp),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
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
fun LoadingChipsPreview() {
    LoadingChips("Loading")
}

