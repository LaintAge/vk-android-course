package com.example.trainingproject.domain.applist

interface ShowcaseAppsRepository {
    suspend fun getShowcaseApps(): List<ShowcaseApp>
    suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float>
    suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float>
}