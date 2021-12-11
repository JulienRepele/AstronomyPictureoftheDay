package com.repele.astronomypictureoftheday.domain.use_case

import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import javax.inject.Inject

class GetPictureDetails @Inject constructor(
    private val repository: NasaPictureRepository,
) {

    operator fun invoke(pictureID: String): PictureOfTheDay? = repository.getPicture(pictureID)
}