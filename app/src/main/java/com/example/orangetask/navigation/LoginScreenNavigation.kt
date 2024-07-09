package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.cleanNavigaten
import com.example.orangetask.ui.login.LoginScreen
import com.example.orangetask.ui.login.LoginScreenViewModel
import kotlinx.coroutines.launch

const val LOGIN_ROUTE = "LoginRoute"
fun NavGraphBuilder.LoginScreenNavigation(navController: NavHostController) {
    composable(LOGIN_ROUTE) {
        val viewModel = hiltViewModel<LoginScreenViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutine = rememberCoroutineScope()
        LoginScreen(
            onClickNext = {
                coroutine.launch {
                    viewModel.createUser()
                }
                navController.cleanNavigaten(HOME_ROUTE) },
            state = state)
    }


}