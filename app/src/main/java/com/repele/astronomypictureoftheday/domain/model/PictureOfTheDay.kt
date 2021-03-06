package com.repele.astronomypictureoftheday.data

class PictureOfTheDay(
    val date: String,
    val title: String,
    val explanation: String,
    val contentUrl: String?, // Could be a link to an image or a video, depending on the mediaType
    val thumbnailUrl: String?,
    val copyright: String?,
    val mediaType: MediaType?,
)

enum class MediaType(val tag: String) {
    IMAGE("image"),
    VIDEO("video");

    companion object {
        fun find(tag: String?): MediaType? = values().find { it.tag == tag }
    }
}