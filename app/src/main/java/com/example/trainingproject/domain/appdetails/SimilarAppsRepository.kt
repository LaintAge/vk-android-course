package com.example.trainingproject.domain.appdetails

interface SimilarAppsRepository {
    suspend fun getSimilarApps(): List<SimilarApp>
}