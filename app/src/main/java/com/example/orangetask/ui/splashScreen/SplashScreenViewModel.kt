package com.example.orangetask.ui.splashScreen

import com.example.orangetask.preferences.PreferencesKey
import kotlinx.coroutines.flow.asStateFlow
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SplashScreenUiState())
    val uiState: StateFlow<SplashScreenUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            initialDestination()
        }
    }

    private suspend fun initialDestination() {
        delay(Random.nextLong(300, 1000))
        dataStore.data.collect {
            val appState = if (it[PreferencesKey.logged] == true) {
                AppState.Logged
            } else {
                AppState.LoggedOut
            }
            _uiState.value = _uiState.value.copy(
                appState = appState
            )
        }
    }
}

