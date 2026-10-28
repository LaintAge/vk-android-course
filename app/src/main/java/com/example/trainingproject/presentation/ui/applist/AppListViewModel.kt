package com.example.trainingproject.presentation.ui.applist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trainingproject.domain.applist.GetShowcaseAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getShowcaseAppsUseCase: GetShowcaseAppsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<AppListState>(AppListState.Loading)
    val state = _state.asStateFlow()

    private val _events = Channel<AppListEvent>(BUFFERED)
    val events = _events.receiveAsFlow()

    private var loadingJob: Job? = null

    init {
        getShowcaseApps()
    }

    fun onToolbarClicked() {
        viewModelScope.launch {
            _events.send(AppListEvent.ShowSnackbar("Вы нажали на Toolbar!"))
        }
    }

    fun onShowcaseAppClicked(showcaseAppId: String) {
        viewModelScope.launch {
            _events.send(AppListEvent.NavigateToDetailApp(showcaseAppId))
        }
    }

    private fun getShowcaseApps() {
        loadingJob?.cancel()
        loadingJob = viewModelScope.launch {
            _state.value = AppListState.Loading

            try {
                val showcaseApps = getShowcaseAppsUseCase()
                _state.value = AppListState.Content(
                    showcaseApps = showcaseApps,
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _state.value = AppListState.Error
                Log.e("AppListViewModel", "Failed to load app", e)
            }
        }
    }
}
