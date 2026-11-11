package com.example.trainingproject.data.applist

import retrofit2.http.GET

interface ShowcaseAppsApi {
    @GET("catalog")
    suspend fun getShowcaseApps(): List<ShowcaseAppDto>
}