package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.navigateToDialogFormProductScreen
import com.example.orangetask.navigateToSearchProductScreen
import com.example.orangetask.ui.home.HomeScreen
import com.example.orangetask.ui.home.HomeScreenViewModel
import kotlinx.coroutines.launch


const val HOME_ROUTE = "homeRoute"

fun NavGraphBuilder.homeScreenNavigation(navController: NavHostController) {
    composable(HOME_ROUTE) {
        val viewModel = hiltViewModel<HomeScreenViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutine = rememberCoroutineScope()




        HomeScreen(
            state = state,
            clickSearchButton = {
                navController.navigateToSearchProductScreen()
            },
            onCheckBoxChange = { product, isCheck ->
                coroutine.launch {
                    viewModel.updateProductCheckState(product, isCheck)
                }
            }, clickFloatActionButton = {
                navController.navigateToDialogFormProductScreen()
            },
            removeProduct = {
                coroutine.launch {
                    viewModel.removeProduct(it)
                }
            }


        )
    }
}


