package com.example.trainingproject.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.trainingproject.presentation.navigation.AppNavHost
import com.example.trainingproject.presentation.ui.AppDetailsScreen
import com.example.trainingproject.presentation.theme.VkEducationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) { innerPadding ->
                VkEducationTheme() {
                    AppNavHost(Modifier.padding(innerPadding))
                }
            }
        }
    }
}