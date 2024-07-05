package com.example.orangetask.ui.home

import com.example.orangetask.data.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class HomeScreenUiState(
    val products: List<Product> = emptyList(),
    val name: String = "",
    val onNameChange: (String) -> Unit = {},
    val checkBox: Boolean = false,
    val onCheckBoxChange: (Boolean) -> Unit = {}
)