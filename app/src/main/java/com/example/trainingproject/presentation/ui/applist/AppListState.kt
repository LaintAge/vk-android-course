package com.example.trainingproject.presentation.ui.applist

import androidx.compose.runtime.Immutable
import com.example.trainingproject.domain.applist.ShowcaseApp

@Immutable
sealed interface AppListState {
    data object Error : AppListState
    data object Loading : AppListState
    data class Content(
        val showcaseApps: List<ShowcaseApp>,
    ) : AppListState
}