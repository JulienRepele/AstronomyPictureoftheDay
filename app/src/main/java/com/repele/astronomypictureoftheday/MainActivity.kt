package com.repele.astronomypictureoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.repele.astronomypictureoftheday.presentation.PituresViewModel
import com.repele.astronomypictureoftheday.presentation.composable.PictureDetailsPreview
import com.repele.astronomypictureoftheday.presentation.composable.ScreenPictureOfTheDay
import com.repele.astronomypictureoftheday.presentation.theme.AstronomyPictureOfTheDayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pituresViewModel by viewModels<PituresViewModel>()

        setContent {
            AstronomyPictureOfTheDayTheme {
                Scaffold(
                    content = { contentPadding ->
                        val navController = rememberNavController()
                        NavHost(navController = navController, startDestination = "grid") {
                            composable("grid") { ScreenPictureOfTheDay(navController, pituresViewModel, contentPadding) }
                            composable("picture_details") { PictureDetailsPreview() }
                        }
                    }
                )
            }
        }
    }
}
