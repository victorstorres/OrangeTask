package com.example.orangetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.example.orangetask.theme.OrangeTaskTheme
import com.example.orangetask.ui.login.LoginScreen
import com.example.orangetask.ui.login.LoginScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeTaskTheme {
                    val viewModel by viewModels<LoginScreenViewModel>()
                   val state = viewModel.uiState.collectAsState()
                   LoginScreen(state = state.value)
            }
        }
    }
}

