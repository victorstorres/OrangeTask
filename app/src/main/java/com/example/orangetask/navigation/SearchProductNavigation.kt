package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.orangetask.cleanNavigaten
import com.example.orangetask.ui.searchProduct.SearchProductScreen
import com.example.orangetask.ui.searchProduct.SearchProductViewModel

const val SEARCH_ROUTE = "SearchRoute"

fun NavGraphBuilder.SearchProductNavigation(navController: NavHostController) {
    composable(SEARCH_ROUTE) {

        val viewModel = hiltViewModel<SearchProductViewModel>()
        val state by viewModel.uiState.collectAsState()

        SearchProductScreen(
            state = state,
            onClickBack = {
                navController.cleanNavigaten(HOME_ROUTE)
            }
        )

    }
}

