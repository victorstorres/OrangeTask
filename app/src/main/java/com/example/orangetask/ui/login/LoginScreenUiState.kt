package com.example.orangetask.ui.login

data class LoginScreenUiState(
    val name: String = "",
    val onNameChange:(String) -> Unit = { },
    val onClickNextPage: () -> Unit = { },
)