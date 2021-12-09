package com.repele.astronomypictureoftheday.data.source

import com.repele.astronomypictureoftheday.data.MediaType
import com.repele.astronomypictureoftheday.data.PictureOfTheDay

fun NasaPicture.toPictureOfTheDay() = PictureOfTheDay(
    date = date,
    title = title,
    explanation = explanation,
    contentUrl = hdurl ?: url,
    thumbnailUrl = thumbnailUrl ?: url,
    mediaType = MediaType.find(mediaType)
)
