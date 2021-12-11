package com.repele.astronomypictureoftheday.di

import com.repele.astronomypictureoftheday.data.repository.NasaPictureRepositoryImpl
import com.repele.astronomypictureoftheday.data.source.NasaApi
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import com.repele.astronomypictureoftheday.domain.use_case.GetPageOfPicture
import com.repele.astronomypictureoftheday.domain.use_case.GetPictureDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNasaApi(): NasaApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(NasaApi.BASE_URL)
        .build()
        .create(NasaApi::class.java)

    @Singleton
    @Provides
    fun provideNasaPictureRepository(nasaApi: NasaApi): NasaPictureRepository = NasaPictureRepositoryImpl(nasaApi)

    @Singleton
    @Provides
    fun providesGetPageOfPictures(pictureRepository: NasaPictureRepository) = GetPageOfPicture(pictureRepository)

    @Singleton
    @Provides
    fun providesGetPictureDetails(pictureRepository: NasaPictureRepository) = GetPictureDetails(pictureRepository)
}
