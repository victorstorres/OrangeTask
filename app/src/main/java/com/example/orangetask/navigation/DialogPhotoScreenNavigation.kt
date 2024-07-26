package com.example.orangetask.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import com.example.orangetask.ui.dialogForm.DialogPhotoScreen
import com.example.orangetask.ui.dialogForm.DialogPhotoViewModel
import kotlinx.coroutines.launch

const val DIALOG_PHOTO_SCREEN = "DialogPhoto"


fun NavGraphBuilder.DialogPhotoScreenNavigation(navController: NavHostController) {
    dialog(
        route = DIALOG_PHOTO_SCREEN,
    ) {


        val viewModel = hiltViewModel<DialogPhotoViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutineScope = rememberCoroutineScope()


        DialogPhotoScreen(
            state = state,
            onClickSavePhoto = {
                coroutineScope.launch {
                    viewModel.saveImage()
                }
                navController.popBackStack()
            },
            closeDialog = {
                navController.popBackStack()
            }
        )


    }
}