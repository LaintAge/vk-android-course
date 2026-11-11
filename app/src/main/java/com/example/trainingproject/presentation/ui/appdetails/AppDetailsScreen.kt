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
        when (state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier.padding(innerPadding)
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { getAppDetails() },
                    modifier = Modifier.padding(innerPadding)
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                )
            }
        }
    }
}
