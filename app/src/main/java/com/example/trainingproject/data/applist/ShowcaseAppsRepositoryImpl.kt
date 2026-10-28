package com.example.trainingproject.data.applist

import com.example.trainingproject.domain.applist.ShowcaseApp
import com.example.trainingproject.domain.applist.ShowcaseAppsRepository
import javax.inject.Inject


class ShowcaseAppsRepositoryImpl @Inject constructor(
    private val api: ShowcaseAppsApi,
    private val mapper: ShowcaseAppMapper,
) : ShowcaseAppsRepository {
    override suspend fun getShowcaseApps(): List<ShowcaseApp> =
        api.getShowCaseApps().map(mapper::toDomain)
}