package com.example.orangetask.ui.dialogForm

import androidx.lifecycle.ViewModel
import com.example.orangetask.data.Product
import com.example.orangetask.dataBase.dao.ProductDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DialogFormProductViewModel @Inject constructor(
    private val productDao: ProductDao,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DialogFormProductUiState())

    val uiState: StateFlow<DialogFormProductUiState>
        get() = _uiState.asStateFlow()


    init {
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

    suspend fun saveProduct(url: String) {
            productDao.addProduct(
                Product(
                    name = _uiState.value.name,
                    image = url
                )
            )
    }
}