package com.example.trainingproject.domain.applist

import javax.inject.Inject

class GetShowcaseAppsUseCase @Inject constructor(
    private val repository: ShowcaseAppsRepository,
) {
    suspend operator fun invoke(): List<ShowcaseApp> = repository.getShowcaseApps()
}