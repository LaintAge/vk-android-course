package com.example.trainingproject.di

import com.example.trainingproject.data.appdetails.AppDetailsApi
import com.example.trainingproject.data.appdetails.AppDetailsRepositoryImpl
import com.example.trainingproject.data.appdetails.SimilarAppsApi
import com.example.trainingproject.data.appdetails.SimilarAppsRepositoryImpl
import com.example.trainingproject.domain.appdetails.AppDetailsRepository
import com.example.trainingproject.domain.appdetails.SimilarAppsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDetailsModule {

    @Binds
    abstract fun bindAppDetailsRepository(
        impl: AppDetailsRepositoryImpl
    ): AppDetailsRepository

    @Binds
    abstract fun bindSimilarAppsRepository(
        impl: SimilarAppsRepositoryImpl
    ): SimilarAppsRepository

    companion object {
        @Provides
        @Singleton
        fun provideAppDetailsApi(retrofit: Retrofit): AppDetailsApi {
            return retrofit.create(AppDetailsApi::class.java)
        }

        @Provides
        @Singleton
        fun provideSimilarAppsApi(): SimilarAppsApi {
            return SimilarAppsApi()
        }
    }
}