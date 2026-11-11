package com.example.trainingproject.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trainingproject.R
import com.example.trainingproject.presentation.ui.appdetails.AppDetailsEvent
import com.example.trainingproject.presentation.ui.appdetails.AppDetailsScreen
import com.example.trainingproject.presentation.ui.appdetails.AppDetailsViewModel
import com.example.trainingproject.presentation.ui.applist.AppListEvent
import com.example.trainingproject.presentation.ui.applist.AppListScreen
import com.example.trainingproject.presentation.ui.applist.AppListViewModel
import kotlinx.serialization.Serializable

@Serializable
data object ListDestination

@Serializable
data class DetailDestination(val appId: String)

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val snackbarHostState = remember { SnackbarHostState() }

    NavHost(
        navController = navController,
        startDestination = ListDestination,
        modifier = modifier.fillMaxSize()
    ) {
        composable<ListDestination> {
            val viewModel: AppListViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()

            LaunchedEffect(viewModel) {
                viewModel.events.collect { event ->
                    when (event) {
                        is AppListEvent.ShowSnackbar -> {
                            snackbarHostState.showSnackbar(event.message)
                        }
                        is AppListEvent.NavigateToDetailApp -> {
                            navController.navigate(DetailDestination(appId = event.appId))
                        }
                    }
                }
            }

            AppListScreen(
                state = state,
                snackbarHostState = snackbarHostState,
                onToolbarClick = { viewModel.onToolbarClicked() },
                onAppClick = { app -> viewModel.onShowcaseAppClicked(app.id) },
                getAppsShowcase = { viewModel.getShowcaseApps() }
            )
        }

        composable<DetailDestination> {
            val viewModel: AppDetailsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            val underDevelopmentText = stringResource(R.string.under_development)

            LaunchedEffect(viewModel) {
                viewModel.events.collect { event ->
                    when (event) {
                        is AppDetailsEvent.UnderDevelopment -> {
                            snackbarHostState.showSnackbar(underDevelopmentText)
                        }
                        is AppDetailsEvent.NavigateBack -> {
                            navController.navigateUp()
                        }
                        is AppDetailsEvent.NavigateToShowcaseApp -> {
                            navController.navigate(DetailDestination(appId = event.appId))
                        }
                    }
                }
            }

            AppDetailsScreen(
                state = state,
                snackbarHostState = snackbarHostState,
                getAppDetails = { viewModel.getAppDetails() },
                onBackClick = { viewModel.onBackClicked() },
                showUnderDevelopmentMessage = { viewModel.showUnderDevelopmentMessage() },
                onAppClick = { appID -> viewModel.onShowcaseAppClicked(appID) },
                collapseDescription = { viewModel.collapseDescription() },
            )
        }
    }
}