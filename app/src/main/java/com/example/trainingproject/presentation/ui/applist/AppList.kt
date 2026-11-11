package com.example.trainingproject.presentation.ui.applist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainingproject.domain.applist.ShowcaseApp

@Composable
fun AppList(
    modifier: Modifier = Modifier,
    onAppClick: (ShowcaseApp) -> Unit,
    appList: List<ShowcaseApp>,
    ratings: Map<String, Float>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        appList.forEach { app ->
            val rating = ratings[app.id]
            

            item {
                AppListItem(
                    app = app,
                    onClick = { onAppClick(app) },
                    rating = rating,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}