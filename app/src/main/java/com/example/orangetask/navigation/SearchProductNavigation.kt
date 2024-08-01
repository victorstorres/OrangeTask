package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.cleanNavigaten
import com.example.orangetask.ui.searchProduct.SearchProductScreen
import com.example.orangetask.ui.searchProduct.SearchProductViewModel
import kotlinx.coroutines.launch

const val SEARCH_ROUTE = "SearchRoute"

fun NavGraphBuilder.searchProductNavigation(navController: NavHostController) {
    composable(SEARCH_ROUTE) {

        val viewModel = hiltViewModel<SearchProductViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutine = rememberCoroutineScope()

        SearchProductScreen(
            state = state,
            onClickBack = {
                navController.cleanNavigaten(HOME_ROUTE)
            },
            removeProduct = {
                coroutine.launch {
                    viewModel.removeProduct(it)
                }
            }

        )

    }
}

