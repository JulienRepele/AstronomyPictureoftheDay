package com.repele.astronomypictureoftheday.data.source

import com.google.gson.annotations.SerializedName

class NasaPicture(
    @SerializedName("date") val date: String,
    @SerializedName("title") val title: String,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("hdurl") val hdurl: String?,
    @SerializedName("media_type") val mediaType: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("thumbnail_url") val thumbnailUrl: String?,
)
