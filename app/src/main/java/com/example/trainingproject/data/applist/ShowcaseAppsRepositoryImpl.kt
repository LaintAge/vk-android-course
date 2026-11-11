package com.example.trainingproject.data.applist

import android.util.Log
import com.example.trainingproject.domain.applist.ShowcaseApp
import com.example.trainingproject.domain.applist.ShowcaseAppsRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import kotlin.system.measureTimeMillis


class ShowcaseAppsRepositoryImpl @Inject constructor(
    private val api: ShowcaseAppsApi,
    private val mapper: ShowcaseAppMapper,
) : ShowcaseAppsRepository {
    override suspend fun getShowcaseApps(): List<ShowcaseApp> =
        api.getShowcaseApps().map(mapper::toDomain)

    override suspend fun loadRatingsSequentially(ids: List<String>): Map<String, Float> {
        val ratings = mutableMapOf<String, Float>()
        var timeInMillis = 0L

        timeInMillis = measureTimeMillis {
            for (id in ids) {
                ratings[id] = api.getRating(id)
            }
        }
        Log.d("RatingTest", "Sequential loading took: $timeInMillis ms")
        return ratings
    }

    override suspend fun loadRatingsInParallel(ids: List<String>): Map<String, Float> =
        coroutineScope {
            var result: Map<String, Float> = emptyMap()

            val timeInMillis = measureTimeMillis {
                result = ids.map { id ->
                    async { id to api.getRating(id) }
                }.awaitAll().toMap()
            }
            Log.d("RatingTest", "Parallel loading took: $timeInMillis ms")
            result
        }
}