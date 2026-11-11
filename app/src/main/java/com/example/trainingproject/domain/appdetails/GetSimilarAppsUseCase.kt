package com.example.trainingproject.domain.appdetails

import javax.inject.Inject

class GetSimilarAppsUseCase @Inject constructor(
    private val repository: SimilarAppsRepository,
) {
    suspend operator fun invoke(): List<SimilarApp> = repository.getSimilarApps()
}