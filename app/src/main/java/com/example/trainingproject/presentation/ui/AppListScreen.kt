package com.example.trainingproject.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.trainingproject.presentation.data.App

@Composable
fun AppListScreen(modifier: Modifier = Modifier, appList: List<App>, onAppClick: (App) -> Unit = {}) {
        Column(modifier = modifier) {
            AppListToolbar()
            AppList(
                onAppClick= onAppClick,
                appList = appList,
                modifier= Modifier
                .padding(horizontal = 16.dp )
                .padding(top = 8.dp)
            )
        }
}