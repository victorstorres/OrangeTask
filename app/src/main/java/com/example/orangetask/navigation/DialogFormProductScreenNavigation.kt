package com.example.orangetask.navigation

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import com.example.orangetask.data.Product
import com.example.orangetask.ui.dialogForm.DialogFormProductScreen
import com.example.orangetask.ui.dialogForm.DialogFormProductUiState
import com.example.orangetask.ui.dialogForm.DialogFormProductViewModel

const val DIALOG_FORM_PRODUCT_SCREEN = "FormProductScree"

fun NavGraphBuilder.DialogFormProductScreenNavigation(navController: NavHostController) {
    dialog(
        route = DIALOG_FORM_PRODUCT_SCREEN,
    ) {


        val viewModel = hiltViewModel<DialogFormProductViewModel>()
        val state by viewModel.uiState.collectAsState()

        DialogFormProductScreen(
            state = state,
            onClickSaveProduct = {
                viewModel.saveProduct()
                Log.e("Teste", "Botão clicado")
                navController.popBackStack()
            }
        )
    }
}