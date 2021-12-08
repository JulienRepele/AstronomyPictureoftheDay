package com.repele.astronomypictureoftheday.data

import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET("planetary/apod")
    suspend fun getPicturesList(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String = "YWDmrwcQHsbWuQW1Zs4ddw0HFTsgYl004YjDil90",
        @Query("thumbs") thumbs: Boolean = true,
    ): List<NasaPicture>

    companion object {
        const val BASE_URL = "https://api.nasa.gov/"
    }
}