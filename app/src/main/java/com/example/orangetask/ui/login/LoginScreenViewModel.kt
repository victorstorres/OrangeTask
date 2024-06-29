package com.example.orangetask.ui.login
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel@Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginScreenUiState())

    val uiState : StateFlow<LoginScreenUiState>
        get() =_uiState.asStateFlow()


    init {
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






}