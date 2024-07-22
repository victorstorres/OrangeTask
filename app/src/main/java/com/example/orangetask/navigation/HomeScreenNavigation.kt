package com.example.orangetask.navigation

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.navigateToDialogFormProductScreen
import com.example.orangetask.ui.home.HomeScreen
import com.example.orangetask.ui.home.HomeScreenViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


const val HOME_ROUTE = "homeRoute"

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.HomeScreenNavigation(navController: NavHostController) {
    composable(HOME_ROUTE) {
        val viewModel = hiltViewModel<HomeScreenViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutine = rememberCoroutineScope()




        HomeScreen(
            modifier = Modifier.padding(5.dp),
            state = state,
            onCheckBoxChange = { product , isCheck->
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