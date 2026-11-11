package com.example.trainingproject.data.applist

import kotlinx.coroutines.delay
import retrofit2.http.GET
import kotlin.time.Duration.Companion.milliseconds

interface ShowcaseAppsApi {
    @GET("catalog")
    suspend fun getShowcaseApps(): List<ShowcaseAppDto>

    suspend fun getRating(id: String): Float {
        delay(1500.milliseconds)
        return (30..50).random() / 10f
    }
}