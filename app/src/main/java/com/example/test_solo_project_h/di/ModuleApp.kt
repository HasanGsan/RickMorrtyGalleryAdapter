package com.example.test_solo_project_h.di

import com.example.test_solo_project_h.data.api.ApiService
import com.example.test_solo_project_h.data.repository.RickMortyRepositoryImpl
import com.example.test_solo_project_h.domain.repository.RickMortyRepository
import com.example.test_solo_project_h.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ModuleApp {

    @Singleton
    @Provides
    fun providesRetrofit() = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesRepository(apiService: ApiService) : RickMortyRepository = RickMortyRepositoryImpl(apiService)
}