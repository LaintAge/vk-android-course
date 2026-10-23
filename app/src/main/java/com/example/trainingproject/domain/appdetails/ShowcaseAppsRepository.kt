package com.example.trainingproject.domain.appdetails

interface ShowcaseAppsRepository {
    suspend fun getShowcaseApps(): List<ShowcaseApp>
}