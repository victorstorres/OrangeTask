package com.example.orangetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.orangetask.theme.OrangeTaskTheme
import com.example.orangetask.ui.OrangeTaskNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OrangeTaskTheme {
                    val navController = rememberNavController()
                    OrangeTaskNavHost(navController = navController)
            }
        }
    }
}

