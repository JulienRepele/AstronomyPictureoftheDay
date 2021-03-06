package com.repele.astronomypictureoftheday.data.repository

import com.repele.astronomypictureoftheday.data.PictureOfTheDay
import com.repele.astronomypictureoftheday.data.source.DateParameter
import com.repele.astronomypictureoftheday.data.source.NasaApi
import com.repele.astronomypictureoftheday.data.source.toPictureOfTheDay
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class NasaPictureRepositoryImpl @Inject constructor(
    private val api: NasaApi,
) : NasaPictureRepository {

    private val pictureList = emptyList<PictureOfTheDay>().toMutableList()
    private val dateParameter = DateParameter()

    override suspend fun getPictureList(page: Int): List<PictureOfTheDay> = api.getPicturesList(
        dateParameter.getStartDateParameter(page),
        dateParameter.getEndDateParameter(page),
    ).map { it.toPictureOfTheDay() }.also { pictureList.addAll(it) }

    override fun getPicture(id: String): PictureOfTheDay? = pictureList.firstOrNull { it.date == id }
}
