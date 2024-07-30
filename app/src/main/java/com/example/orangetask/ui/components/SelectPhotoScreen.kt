package com.example.orangetask.ui.components

import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SelectPhotoScreen(modifier: Modifier = Modifier) {

//    val context = LocalContext.current
//    val pickMedia = rememberLauncherForActivityResult(
//        ActivityResultContracts.PickVisualMedia()
//    ) { uri ->
//        if (uri != null) {
//            val contentResolver = context.contentResolver
//            val takeFlags: Int = Intent.FLAG_GRANT_READ_URI_PERMISSION
//            contentResolver.takePersistableUriPermission(uri, takeFlags)
//
//            viewModelMessage.loadMediaInScreen(uri.toString())
////                    context.showLog("Selected ${uri}")
//        } else {
//            context.showLog("No photos")
//        }
//    }


    Box{

    }
}


@Preview(showBackground = true)
@Composable
private fun SelectPhotoPrev() {
    SelectPhotoScreen()
}