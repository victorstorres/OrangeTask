package com.example.orangetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.orangetask.theme.OrangeTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeTaskTheme {
                val navController = rememberNavController()
                OrangeTaskNavHost(navController = navController)
                
            }
        }
    }
}

