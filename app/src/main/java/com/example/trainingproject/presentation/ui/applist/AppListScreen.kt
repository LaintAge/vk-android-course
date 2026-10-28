package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.trainingproject.domain.applist.ShowcaseApp

@Composable
fun AppListScreen(
    modifier: Modifier = Modifier,
    state: AppListState,
    onToolbarClick: () -> Unit,
    onAppClick: (ShowcaseApp) -> Unit,
) {
    when (state) {
        is AppListState.Loading -> {
            AppListLoading(
                modifier = modifier.fillMaxSize()
            )
        }

        is AppListState.Error -> {
            AppListError(
                onRefreshClick = {},
                modifier = modifier.fillMaxSize()
            )
        }

        is AppListState.Content -> {
            AppListContent(
                modifier = modifier,
                content = state,
                onAppClick = onAppClick,
                onToolbarClick = onToolbarClick,
            )
        }
    }

}