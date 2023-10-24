package com.wladimirbr.bakeryourdream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi

import com.wladimirbr.bakeryourdream.navigation.SetupNavGraph
import com.wladimirbr.bakeryourdream.ui.theme.BakeryOurDreamTheme
import dagger.hilt.android.AndroidEntryPoint
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BakeryOurDreamTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}
