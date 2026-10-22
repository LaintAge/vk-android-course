package com.example.trainingproject.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.trainingproject.presentation.data.AppsData
import com.example.trainingproject.presentation.ui.AppDetailsScreen
import com.example.trainingproject.presentation.ui.AppListScreen
import kotlinx.serialization.Serializable

@Serializable
data object ListDestination

@Serializable
data class DetailDestination(val  appId: Int)
@Composable
fun AppNavHost(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ListDestination
    ) {
        composable<ListDestination> {
            AppListScreen(
                modifier = modifier,
                appList = AppsData.apps,
                onAppClick = { app ->
                    navController.navigate(DetailDestination(app.id))
                }
            )
        }

        composable<DetailDestination> { backStackEntry ->
            val destination = backStackEntry.toRoute<DetailDestination>()
            val app = AppsData.apps.find { it.id == destination.appId }

            if (app != null) {
                AppDetailsScreen(
                    modifier = modifier,
                    app = app,
                    onBackClick = { navController.navigateUp() },
                    onShowcaseAppClick = { showcaseApp ->
                        if (showcaseApp.id != destination.appId) {
                            navController.navigate(DetailDestination(showcaseApp.id))
                        }
                    }
                )
            }
        }
    }
}