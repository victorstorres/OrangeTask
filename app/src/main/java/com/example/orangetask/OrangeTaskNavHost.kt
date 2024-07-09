package com.example.orangetask

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import com.example.orangetask.ui.splashScreen.SplashScreenViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.orangetask.navigation.DIALOG_FORM_PRODUCT_SCREEN
import com.example.orangetask.navigation.DialogFormProductScreenNavigation
import com.example.orangetask.navigation.HOME_ROUTE
import com.example.orangetask.navigation.HomeScreenNavigation
import com.example.orangetask.navigation.INITIALSCREEN_ROUTE
import com.example.orangetask.navigation.InitialScreenNavigation
import com.example.orangetask.navigation.LOGIN_ROUTE
import com.example.orangetask.navigation.LoginScreenNavigation
import com.example.orangetask.navigation.SplashScreenNavigation
import com.example.orangetask.navigation.SplashScreenRoute
import com.example.orangetask.ui.splashScreen.AppState

@Composable
fun OrangeTaskNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = SplashScreenRoute) {
        LoginScreenNavigation(navController)
        InitialScreenNavigation(navController)
        HomeScreenNavigation(navController)
        DialogFormProductScreenNavigation(navController)
        SplashScreenNavigation(
            navigationToLogin = { navController.navigateToLoginScreen() },
            navigationToHome = { navController.navigateToHomeScreen() }
        )

    }

}


fun NavHostController.cleanNavigaten(rota: String) = this.navigate(rota) {
    popUpTo(0)

}

fun NavHostController.navigateToDialogFormProductScreen() {
    navigate(DIALOG_FORM_PRODUCT_SCREEN)
}

fun NavHostController.navigateToHomeScreen() {
    navigate(HOME_ROUTE)
}

fun NavHostController.navigateToLoginScreen() {
    navigate(LOGIN_ROUTE)
}

fun NavHostController.navigateToInitialScreen() {
    navigate(INITIALSCREEN_ROUTE)
}



