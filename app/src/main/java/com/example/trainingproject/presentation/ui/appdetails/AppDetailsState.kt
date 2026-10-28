package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.runtime.Immutable
import com.example.trainingproject.domain.appdetails.AppDetails
import com.example.trainingproject.domain.applist.ShowcaseApp
import com.example.trainingproject.domain.appdetails.SimilarApp

@Immutable
sealed interface AppDetailsState {
    data object Error : AppDetailsState
    data object Loading : AppDetailsState
    data class Content(
        val appDetails: AppDetails,
        val similarApps: List<SimilarApp>,
        val showcaseApps: List<ShowcaseApp>,
        val descriptionCollapsed: Boolean,
    ) : AppDetailsState
}