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
        val installState: InstallState = InstallState.NotInstalled
    ) : AppDetailsState
}

@Immutable
sealed interface InstallState {
    data object NotInstalled : InstallState
    data class Installing(val progress: Int) : InstallState
    data object Installed : InstallState
}