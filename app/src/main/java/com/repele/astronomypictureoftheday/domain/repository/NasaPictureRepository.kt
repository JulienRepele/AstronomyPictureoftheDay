package com.repele.astronomypictureoftheday.domain.repository

import com.repele.astronomypictureoftheday.data.PictureOfTheDay

interface NasaPictureRepository {

    suspend fun getPictureList(limit: Int, offset: Int): List<PictureOfTheDay>

    fun getPicture(id: String): PictureOfTheDay?
}