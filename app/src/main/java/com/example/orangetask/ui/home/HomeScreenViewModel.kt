package com.example.orangetask.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.orangetask.data.Product
import com.example.orangetask.dataBase.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
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
                onCheckBoxChange = {
                    _uiState.value = _uiState.value.copy(
                        checkBox = it
                    )
                }

            )
        }
    }

    suspend fun listProduct() {
        viewModelScope.launch {
            productDao.searchProduct().collect { listProduct ->
                _uiState.value = _uiState.value.copy(
                    products = listProduct
                )
            }
        }
    }
}
