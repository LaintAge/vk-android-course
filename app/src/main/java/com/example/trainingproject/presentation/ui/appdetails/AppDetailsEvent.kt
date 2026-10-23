package com.example.trainingproject.presentation.ui.appdetails

sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
    data object NavigateBack : AppDetailsEvent
    data class NavigateToShowcaseApp(val appId: String) : AppDetailsEvent
}