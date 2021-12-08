package com.repele.astronomypictureoftheday.domain.repository

import com.repele.astronomypictureoftheday.data.PictureOfTheDay

interface NasaPictureRepository {

    suspend fun getPictureList(page: Int = 0): List<PictureOfTheDay>

    fun getPicture(id: String): PictureOfTheDay?
}