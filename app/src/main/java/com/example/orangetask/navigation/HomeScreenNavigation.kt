package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.navigateToDialogFormProductScreen
import com.example.orangetask.ui.home.HomeScreen
import com.example.orangetask.ui.home.HomeScreenViewModel
import kotlinx.coroutines.launch


const val HOME_ROUTE = "homeRoute"

fun NavGraphBuilder.HomeScreenNavigation(navController: NavHostController) {
    composable(HOME_ROUTE) {
        val viewModel = hiltViewModel<HomeScreenViewModel>()
        val state by viewModel.uiState.collectAsState()

        HomeScreen(
            state = state,
            onCheckBoxChange = { product, isChecked ->
                viewModel.updateProductCheckState(product, isChecked)
            }, clickFloatActionButton = {
                navController.navigateToDialogFormProductScreen()
            })
    }
}