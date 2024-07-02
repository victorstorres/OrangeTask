package com.example.orangetask.ui.home

data class HomeScreenUiState(
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val checkBox: Boolean = false,
    val onCheckBoxChange: (Boolean) -> Unit = {}

)