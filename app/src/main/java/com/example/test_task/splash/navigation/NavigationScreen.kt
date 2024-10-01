package com.example.test_task.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.splash.screen.SplashScreen

fun NavGraphBuilder.splashScreen() {
    composable(route = Destination.SplashScreen.fullRoute) {
        SplashScreen()
    }
}