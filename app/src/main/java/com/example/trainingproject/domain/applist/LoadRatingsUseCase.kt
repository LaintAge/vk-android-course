package com.example.trainingproject.domain.applist

import javax.inject.Inject

class LoadRatingsUseCase @Inject constructor(
    private val repository: ShowcaseAppsRepository
) {
    suspend fun sequentially(ids: List<String>) = repository.loadRatingsSequentially(ids)
    suspend fun parallel(ids: List<String>) = repository.loadRatingsInParallel(ids)
}