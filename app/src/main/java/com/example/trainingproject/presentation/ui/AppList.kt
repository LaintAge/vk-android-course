package com.example.trainingproject.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainingproject.presentation.data.App

@Composable
fun AppList(
    modifier: Modifier = Modifier,
    onAppClick: (App) -> Unit = {},
    appList: List<App>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        appList.forEach { app ->
            item {
                AppListItem(app = app, onClick = { onAppClick(app) })
            }
        }
    }
}