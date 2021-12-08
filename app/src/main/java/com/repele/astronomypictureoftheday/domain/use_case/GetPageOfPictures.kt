package com.repele.astronomypictureoftheday.domain.use_case

import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository

class GetPageOfPictures(
    private val nasaPictureRepository: NasaPictureRepository,
) {
    suspend operator fun invoke(pageIndex: Int): List<PictureOfTheDay> {
        return nasaPictureRepository.getPictureList(pageIndex)
    }
}