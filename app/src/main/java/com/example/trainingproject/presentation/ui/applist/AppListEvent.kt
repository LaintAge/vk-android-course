package com.example.trainingproject.presentation.ui.applist

sealed interface AppListEvent {
    data class ShowSnackbar(val message: String) : AppListEvent
    data class NavigateToDetailApp(val appId: String) : AppListEvent
}