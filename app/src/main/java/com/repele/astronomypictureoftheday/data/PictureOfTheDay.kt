package com.repele.astronomypictureoftheday.data

class PictureOfTheDay(
    val date: String,
    val title: String,
    val explanation: String,
    val contentUrl: String, // Could be a link to an image or a video, depending on the mediaType
    val hdImageUrl: String?, // Only filled if the type is an image
    val thumbnailUrl: String?, // Only filled if the type is a video
    val mediaType: MediaType,
)

enum class MediaType(val tag: String) {
    IMAGE("image"), VIDEO("video")
}