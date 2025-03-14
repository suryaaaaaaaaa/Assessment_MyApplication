package com.example.assessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.assesment.ui.navigation.theme.AssessmentTheme
import com.example.assessment.naavigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                AppMain()
            }
        }

    @Composable
    fun AppMain() {
        AssessmentTheme {
            Surface(modifier = Modifier.fillMaxSize()) {
                NavGraph()
           }
        }
    }
}


