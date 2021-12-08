package com.repele.astronomypictureoftheday.data

import android.util.Log
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class NasaPictureRepositoryImpl @Inject constructor(
    private val api: NasaApi,
) : NasaPictureRepository {

    private val pictureList = emptyList<PictureOfTheDay>()
    private val dateParameter = DateParameter()

    override suspend fun getPictureList(page: Int): List<PictureOfTheDay> {
        val response = try {
            api.getPicturesList(
                dateParameter.getStartDateParameter(page),
                dateParameter.getEndDateParameter(page),
            ).map { it.toPictureOfTheDay() }
        } catch (e: Exception) {
            Log.d("NasaPictureRepository", e.stackTraceToString())
            emptyList()
        }
        return response
    }

    override fun getPicture(id: String): PictureOfTheDay? = pictureList.firstOrNull { it.date == id }
}