package com.example.orangetask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun OrangeTaskNavHost (
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = INITIALSCREEN_ROUTE) {
        LoginScreenNavigation(navController)
        InitialScreenNavigation(navController)
        HomeScreenNavigation(navController)
    }
    
}


fun NavHostController.navigateToHomeScreen(){
    navigate(HOME_ROUTE)
}

fun NavHostController.navigateToLoginScreen(){
    navigate(LOGIN_ROUTE)
}
fun NavHostController.navigateToInitialScreen(){
    navigate(INITIALSCREEN_ROUTE)
}



