package com.example.trainingproject.data.appdetails

import com.example.trainingproject.domain.appdetails.AppDetails
import com.example.trainingproject.domain.appdetails.AppDetailsRepository
import javax.inject.Inject

class AppDetailsRepositoryImpl @Inject constructor(
    private val appDetailsApi: AppDetailsApi,
    private val mapper: AppDetailsMapper,
) : AppDetailsRepository {

    override suspend fun getAppDetails(id: String): AppDetails {
        val dto = appDetailsApi.get()
        val domain = mapper.toDomain(dto)

        return domain
    }
}