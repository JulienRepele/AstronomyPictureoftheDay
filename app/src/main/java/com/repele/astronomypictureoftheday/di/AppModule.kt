package com.repele.astronomypictureoftheday.di;

import com.repele.astronomypictureoftheday.data.NasaApi
import com.repele.astronomypictureoftheday.data.NasaPictureRepositoryImpl
import com.repele.astronomypictureoftheday.domain.repository.NasaPictureRepository
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

    @ActivityRetainedScoped
    @Provides
    fun provideNasaPictureRepository(nasaApi: NasaApi): NasaPictureRepository = NasaPictureRepositoryImpl(nasaApi)
}
