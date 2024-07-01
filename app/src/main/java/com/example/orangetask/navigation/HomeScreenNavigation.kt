package com.example.orangetask.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.ui.home.HomeScreen


const val HOME_ROUTE = "homeRoute"

fun NavGraphBuilder.HomeScreenNavigation(navController: NavHostController) {
    composable(HOME_ROUTE) {
        HomeScreen()
    }
}