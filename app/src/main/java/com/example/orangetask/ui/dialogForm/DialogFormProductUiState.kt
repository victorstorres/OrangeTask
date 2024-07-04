package com.example.orangetask.ui.dialogForm

data class DialogFormProductUiState(
    val name: String = "",
    val onNameChange : (String) -> Unit = {}
)
