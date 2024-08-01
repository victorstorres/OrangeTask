package com.example.orangetask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.orangetask.navigation.DIALOG_FORM_PRODUCT_SCREEN
import com.example.orangetask.navigation.dialogFormProductScreenNavigation
import com.example.orangetask.navigation.HOME_ROUTE
import com.example.orangetask.navigation.homeScreenNavigation
import com.example.orangetask.navigation.initialScreenNavigation
import com.example.orangetask.navigation.LOGIN_ROUTE
import com.example.orangetask.navigation.loginScreenNavigation
import com.example.orangetask.navigation.SEARCH_ROUTE
import com.example.orangetask.navigation.searchProductNavigation
import com.example.orangetask.navigation.splashScreenNavigation
import com.example.orangetask.navigation.SplashScreenRoute

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun OrangeTaskNavHost(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = SplashScreenRoute) {
        loginScreenNavigation(navController)
        initialScreenNavigation(navController)
        homeScreenNavigation(navController)
        dialogFormProductScreenNavigation(navController)
        searchProductNavigation(navController)
        splashScreenNavigation(
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





