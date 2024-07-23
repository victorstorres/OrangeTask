package com.example.orangetask

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.orangetask.navigation.DIALOG_FORM_PRODUCT_SCREEN
import com.example.orangetask.navigation.DialogFormProductScreenNavigation
import com.example.orangetask.navigation.HOME_ROUTE
import com.example.orangetask.navigation.HomeScreenNavigation
import com.example.orangetask.navigation.INITIALSCREEN_ROUTE
import com.example.orangetask.navigation.InitialScreenNavigation
import com.example.orangetask.navigation.LOGIN_ROUTE
import com.example.orangetask.navigation.LoginScreenNavigation
import com.example.orangetask.navigation.SEARCH_ROUTE
import com.example.orangetask.navigation.SearchProductNavigation
import com.example.orangetask.navigation.SplashScreenNavigation

@Composable
fun OrangeTaskNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = SEARCH_ROUTE) {
        LoginScreenNavigation(navController)
        InitialScreenNavigation(navController)
        HomeScreenNavigation(navController)
        DialogFormProductScreenNavigation(navController)
        SearchProductNavigation(navController)
        SplashScreenNavigation(
            navigationToLogin = { navController.navigateToLoginScreen() },
            navigationToHome = { navController.navigateToHomeScreen() }
        )

    }

}


fun NavHostController.cleanNavigaten(rota: String) = this.navigate(rota) {
    popUpTo(0)

}
fun NavHostController.navigateToSearchProductScreen() {
    navigate(SEARCH_ROUTE)
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



