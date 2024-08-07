package com.example.orangetask.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

     suspend fun removeProduct(id: Long) {
       productDao.removeProduct(id)
    }


     suspend fun updateProductCheckState(idProduct: Long, isCheck: Boolean) {
        val product = productDao.searchProductForId(idProduct).first()
        if (product.id == idProduct) {
                productDao.updateProduct(product.copy(isCheck = isCheck))
                _uiState.update { state ->
                    state.copy(
                        products = state.products.map {
                            if (it.id == idProduct) it.copy(isCheck = isCheck) else it
                        }
                    )
                }
        }
    }

    suspend fun listProduct() {
        productDao.searchProducts().collect { listProduct ->
            _uiState.value = _uiState.value.copy(
                products = listProduct
            )
        }
    }
}

