package com.repele.astronomypictureoftheday.presentation

import androidx.lifecycle.ViewModel
import com.repele.astronomypictureoftheday.data.MediaType
import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class PituresViewModel @Inject constructor(
    private val repository: NasaPictureRepository,
) : ViewModel() {
    private val _pictures = MutableStateFlow<List<PictureOfTheDay>>(mockElements())
    val pictures = _pictures.asStateFlow()

    private fun mockElements() = listOf(
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
        PictureOfTheDay(
            date = "2021-11-25",
            mediaType = MediaType.IMAGE,
            title = "At the Shadow's Edge",
            explanation = "explanation",
            contentUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
            thumbnailUrl = "https://apod.nasa.gov/apod/image/2111/Gout_EclipseCollage-1024.jpg",
        ),
    )
}