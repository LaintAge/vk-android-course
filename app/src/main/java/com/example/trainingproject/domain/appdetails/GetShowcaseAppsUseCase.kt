package com.example.trainingproject.domain.appdetails

class GetShowcaseAppsUseCase(
    private val repository: ShowcaseAppsRepository,
) {
    suspend operator fun invoke(): List<ShowcaseApp> = repository.getShowcaseApps()
}