package com.example.orangetask.ui.home

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orangetask.data.Product
import com.example.orangetask.dataBase.dao.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val productDao: ProductDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            listProduct()
        }
        _uiState.update { state ->
            state.copy(
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },

                )
        }
    }

    fun updateProductCheckState(product: Product, isChecked: Boolean) {
        val updatedProducts = _uiState.value.products.map {
            if (it.id == product.id) it.copy(isCheck = isChecked) else it
        }
        _uiState.value = _uiState.value.copy(products = updatedProducts)
    }
    suspend fun listProduct() {
        productDao.searchProducts().collect { listProduct ->
            _uiState.value = _uiState.value.copy(
                products = listProduct
            )
        }
    }

}

