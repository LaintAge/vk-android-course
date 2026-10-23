package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    state: AppDetailsState,
    onBackClick: () -> Unit,
    onAppClick: (String) -> Unit,
    showUnderDevelopmentMessage: () -> Unit,
    collapseDescription: () -> Unit,
    getAppDetails: () -> Unit,
) {
    when (state) {
        is AppDetailsState.Loading -> {
            AppDetailsLoading(
                modifier = modifier.fillMaxSize()
            )
        }

        is AppDetailsState.Error -> {
            AppDetailsError(
                onRefreshClick = { getAppDetails() },
                modifier = modifier.fillMaxSize()
            )
        }

        is AppDetailsState.Content -> {
            AppDetailsContent(
                content = state,
                onBackClick =  onBackClick,
                onShareClick = showUnderDevelopmentMessage,
                onInstallClick = showUnderDevelopmentMessage,
                onReadMoreClick = collapseDescription,
                onSimilarAppDownloadClick = { showUnderDevelopmentMessage() },
                onDeveloperClick = showUnderDevelopmentMessage,
                onAppClick = onAppClick,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}
