package com.repele.astronomypictureoftheday.data

fun NasaPicture.toPictureOfTheDay() = PictureOfTheDay(
    date = date,
    title = title,
    explanation = explanation,
    contentUrl = hdurl ?: url,
    thumbnailUrl = url ?: thumbnailUrl,
    mediaType = mediaType?.let { MediaType.valueOf(it) }
)