package com.example.trainingproject.applist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AppListScreen(modifier: Modifier = Modifier) {
    val listApp: List<AppInfo> = buildList {
        repeat(15) {index ->
            add(AppInfo(
                "url/${index},",
                "App_${index}",
                "description description description description description",
                "shooter"
            ))
        }
    }

    Scaffold(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
        innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Toolbar()
            AppList(listApp, Modifier
                .padding(horizontal = 16.dp )
                .padding(top = 8.dp)
            )
        }
    }
}