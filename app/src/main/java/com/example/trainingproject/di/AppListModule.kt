package com.example.trainingproject.di

import com.example.trainingproject.data.applist.ShowcaseAppsApi
import com.example.trainingproject.data.applist.ShowcaseAppsRepositoryImpl
import com.example.trainingproject.domain.applist.ShowcaseAppsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppListModule {

    @Binds
    abstract fun bindAppListRepository(
        impl: ShowcaseAppsRepositoryImpl
    ): ShowcaseAppsRepository

    companion object {
        @Provides
        @Singleton
        fun provideAppListApi(retrofit: Retrofit): ShowcaseAppsApi {
            return retrofit.create(ShowcaseAppsApi::class.java)
        }
    }
}