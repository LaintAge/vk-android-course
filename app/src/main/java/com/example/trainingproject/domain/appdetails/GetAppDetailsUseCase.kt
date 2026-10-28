package com.example.trainingproject.domain.appdetails

class GetAppDetailsUseCase(
    private val appDetailsRepository: AppDetailsRepository,
) {
    suspend operator fun invoke(id: String): AppDetails =
        appDetailsRepository.getAppDetails(id)
}