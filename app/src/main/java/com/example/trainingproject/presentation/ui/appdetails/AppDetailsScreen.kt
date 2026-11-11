package com.example.trainingproject.presentation.ui.appdetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppDetailsScreen(
    modifier: Modifier = Modifier,
    state: AppDetailsState,
    snackbarHostState: SnackbarHostState,
    onBackClick: () -> Unit,
    onAppClick: (String) -> Unit,
    showUnderDevelopmentMessage: () -> Unit,
    collapseDescription: () -> Unit,
    getAppDetails: () -> Unit,
) {
    Scaffold (
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        val screenModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)

        when (state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = screenModifier
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { getAppDetails() },
                    modifier = screenModifier
                )
            }

            is AppDetailsState.Content -> {
                AppDetailsContent(
                    content = state,
                    onBackClick = onBackClick,
                    onShareClick = showUnderDevelopmentMessage,
                    onInstallClick = showUnderDevelopmentMessage,
                    onReadMoreClick = collapseDescription,
                    onSimilarAppDownloadClick = { showUnderDevelopmentMessage() },
                    onDeveloperClick = showUnderDevelopmentMessage,
                    onAppClick = onAppClick,
                    modifier = screenModifier
                )
            }
        }
    }
}
