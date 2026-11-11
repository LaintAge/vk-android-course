package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.trainingproject.domain.applist.ShowcaseApp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    state: AppListState,
    snackbarHostState: SnackbarHostState,
    onToolbarClick: () -> Unit,
    onAppClick: (ShowcaseApp) -> Unit,
    getAppsShowcase: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->

        val screenModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)

        when (state) {
            is AppListState.Loading -> {
                AppListLoading(
                    modifier = screenModifier
                )
            }

            is AppListState.Error -> {
                AppListError(
                    onRefreshClick = { getAppsShowcase() },
                    modifier = screenModifier
                )
            }

            is AppListState.Content -> {
                AppListContent(
                    modifier = screenModifier,
                    content = state,
                    onAppClick = onAppClick,
                    onToolbarClick = onToolbarClick,
                )
            }
        }
    }
}
