package com.example.orangetask.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.orangetask.theme.orangeBackGroud
import com.example.orangetask.ui.splashScreen.AppState
import com.example.orangetask.ui.splashScreen.SplashScreenViewModel

const val SplashScreenRoute = ("decideIntial")

fun NavGraphBuilder.splashScreenNavigation(
    navigationToLogin: () -> Unit,
    navigationToHome: () -> Unit,
) {
    composable(SplashScreenRoute) {
        val viewModel = hiltViewModel<SplashScreenViewModel>()
        val state by viewModel.uiState.collectAsState()

        when (state.appState) {
            AppState.Reload -> Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = orangeBackGroud
                )
            }

            AppState.Logged -> {
                LaunchedEffect(Unit) {
                    navigationToHome()
                }
            }

            AppState.LoggedOut -> {
                LaunchedEffect(Unit) {
                    navigationToLogin()
                }
            }
        }
    }
}

