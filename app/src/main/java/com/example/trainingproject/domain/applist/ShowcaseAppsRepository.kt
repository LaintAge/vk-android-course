package com.example.trainingproject.domain.applist

interface ShowcaseAppsRepository {
    suspend fun getShowcaseApps(): List<ShowcaseApp>
}