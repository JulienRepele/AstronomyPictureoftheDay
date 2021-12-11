package com.repele.astronomypictureoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.repele.astronomypictureoftheday.presentation.composable.ScreenPictureDetails
import com.repele.astronomypictureoftheday.presentation.composable.ScreenPictureOfTheDay
import com.repele.astronomypictureoftheday.presentation.theme.AstronomyPictureOfTheDayTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AstronomyPictureOfTheDayTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "grid") {

                    // Grid of photos
                    composable("grid") {
                        ScreenPictureOfTheDay() { navController.navigate("picture_details/$it") }
                    }

                    // Details of photo
                    composable(
                        route = "picture_details/{pictureId}",
                        arguments = listOf(navArgument("pictureId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        ScreenPictureDetails(
                            pictureID = backStackEntry.arguments?.getString("pictureId") ?: ""
                        )
                    }
                }
            }
        }
    }
}
