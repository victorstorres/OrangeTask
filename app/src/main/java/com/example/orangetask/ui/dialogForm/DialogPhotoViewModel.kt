package com.example.orangetask.ui.dialogForm

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import com.example.orangetask.preferences.PreferencesKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DialogPhotoViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>,

    ) : ViewModel() {

    private val _uiState = MutableStateFlow(DialogPhotoUiState())

    val uiState: StateFlow<DialogPhotoUiState>
        get() = _uiState.asStateFlow()

    init {

        _uiState.update { state ->
            state.copy(
                onChangeUrl = {
                    _uiState.value = _uiState.value.copy(
                        url = it
                    )
                }
            )
        }
    }


    suspend fun saveImage() {
        dataStore.edit {
            it[PreferencesKey.imageProduct] = uiState.value.url

        }
    }

}