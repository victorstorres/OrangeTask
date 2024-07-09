package com.example.orangetask.ui.splashScreen

data class SplashScreenUiState(
    val appState: AppState = AppState.Reload
)

sealed class AppState {
    object Logged : AppState()
    object Reload: AppState()
    object LoggedOut : AppState()
}