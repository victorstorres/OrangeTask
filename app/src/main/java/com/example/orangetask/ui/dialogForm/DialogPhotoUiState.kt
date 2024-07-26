package com.example.orangetask.ui.dialogForm

data class DialogPhotoUiState(
    val url: String = "",
    val onChangeUrl: (String) -> Unit = {},
    val onClickSavePhoto: () -> Unit = {},
    val closeDialog: () -> Unit = {},

    )