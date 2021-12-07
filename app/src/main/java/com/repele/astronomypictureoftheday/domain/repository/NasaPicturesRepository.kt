package com.repele.astronomypictureoftheday.domain.repository

import com.repele.astronomypictureoftheday.data.PictureOfTheDay

interface NasaPicturesRepository {

    suspend fun getPictureList(limit: Int, offset: Int): List<PictureOfTheDay>

    suspend fun getPicture(id: String): PictureOfTheDay
}