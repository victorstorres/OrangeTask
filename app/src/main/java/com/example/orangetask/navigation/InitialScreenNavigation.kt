package com.example.orangetask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.navigateToLoginScreen
import com.example.orangetask.ui.login.InitiaScreen

const val INITIALSCREEN_ROUTE = "initialScreen"
fun NavGraphBuilder.InitialScreenNavigation(navController: NavHostController) {
    composable(INITIALSCREEN_ROUTE) {
        InitiaScreen(onClickNext = { navController.navigateToLoginScreen() })
    }
}
