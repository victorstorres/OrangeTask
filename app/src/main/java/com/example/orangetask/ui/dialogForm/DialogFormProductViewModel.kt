package com.example.orangetask.ui.dialogForm

import android.util.Log
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orangetask.dataBase.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DialogFormProductViewModel @Inject constructor(
    private val productDao: ProductDao
): ViewModel() {

    private val _uiState = MutableStateFlow(DialogFormProductUiState())

    val uiState: StateFlow<DialogFormProductUiState>
        get() = _uiState.asStateFlow()


    init {
        saveProduct()
        _uiState.update { state ->
            state.copy(
                onNameChange = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                }
            )
        }
    }


    fun saveProduct(){
        viewModelScope.launch {
            productDao.createProduct(
                _uiState.value.name
            )
        }
        viewModelScope.launch {
            Log.e("Teste", "${productDao.searchProduct().first()}")
        }
    }
}