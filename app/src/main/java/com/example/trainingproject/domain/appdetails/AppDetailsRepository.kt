package com.example.trainingproject.domain.appdetails


interface AppDetailsRepository {
    suspend fun getAppDetails(id: String): AppDetails
}