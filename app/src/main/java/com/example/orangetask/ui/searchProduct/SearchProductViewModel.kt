package com.example.orangetask.ui.searchProduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orangetask.data.Product
import com.example.orangetask.dataBase.dao.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchProductViewModel @Inject constructor(
    val dao: ProductDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchProductUiState())

    val uiState: StateFlow<SearchProductUiState>
        get() = _uiState.asStateFlow()


    init {
        viewModelScope.launch {
        }

        _uiState.update { state ->
            state.copy(
                onChangeNameProduct = {
                    _uiState.value = _uiState.value.copy(
                        nameProduct = it
                    )
                    searchProduct()
                }
            )
        }
    }

    private fun searchProduct() {
        viewModelScope.launch {
            _uiState.value.nameProduct.let { name ->
                val filterProducts = dao.searchProductForName(name).first()
                refreshListProducts(filterProducts)
            }
        }
    }

    private fun refreshListProducts(newList: List<Product>) {
        _uiState.value = _uiState.value.copy(
            products = newList
        )
    }
}