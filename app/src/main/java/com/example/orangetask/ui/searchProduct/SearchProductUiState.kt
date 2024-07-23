package com.example.orangetask.ui.searchProduct

import com.example.orangetask.data.Product

data class SearchProductUiState(
    val nameProduct: String = "",
    val onChangeNameProduct: (String) -> Unit = {},
    val products : List<Product> = emptyList()
)