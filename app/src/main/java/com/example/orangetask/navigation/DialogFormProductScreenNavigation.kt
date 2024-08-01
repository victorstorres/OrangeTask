package com.example.orangetask.navigation

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.dialog
import com.example.orangetask.extension.showMessage
import com.example.orangetask.midia.getAllImages
import com.example.orangetask.midia.imagePermission
import com.example.orangetask.midia.persistUriPermission
import com.example.orangetask.midia.verifyPermission
import com.example.orangetask.ui.dialogForm.DialogFormProductScreen
import com.example.orangetask.ui.dialogForm.DialogFormProductViewModel
import kotlinx.coroutines.launch

const val DIALOG_FORM_PRODUCT_SCREEN = "FormProductScree"

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun NavGraphBuilder.dialogFormProductScreenNavigation(navController: NavHostController) {
    dialog(
        route = DIALOG_FORM_PRODUCT_SCREEN,
    ) {


        val viewModel = hiltViewModel<DialogFormProductViewModel>()
        val state by viewModel.uiState.collectAsState()
        val coroutineScope = rememberCoroutineScope()
        val context = LocalContext.current

        val selectedImageUri = rememberSaveable { mutableStateOf<Uri?>(null) }

        val pickMedia = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri ->
            if (uri != null) {
                context.persistUriPermission(uri)

                selectedImageUri.value = uri
            } else {
                Log.i("Teste", "uri null")
            }
        }
        val requestPermissionLaucher =
            rememberLauncherForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    pickMedia.launch("image/*")
                } else {
                    context.showMessage(
                        "Permissão negada, não será possivel adicionar as fotos",
                        true
                    )
                }
            }

        DialogFormProductScreen(
            state = state,
            onClickSaveProduct = {
                coroutineScope.launch {
                    viewModel.saveProduct(selectedImageUri.value.toString())
                }
                val listImages = mutableListOf<String>()
                context.getAllImages(onLoadImages = { images ->
                    listImages.add(images.toString())
                })


                navController.popBackStack()
            },
            closeDialog = {
                navController.popBackStack()
            },
            onClickCamera = {
                if (context.verifyPermission(imagePermission())) {
                    requestPermissionLaucher.launch(imagePermission())
                } else {
                    pickMedia.launch("image/*")
                }
            },
            imageGallery = selectedImageUri.value.toString()
        )
    }
}

