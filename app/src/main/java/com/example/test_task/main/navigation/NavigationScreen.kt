package com.example.test_task.main.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.test_task.main.screen.MainScreen
import com.example.test_task.navigation.destinations.Destination

fun NavGraphBuilder.mainScreen() {
    Log.d("MyTAG","NavGraphBuilder.mainScreen()")
    composable(route = Destination.MainScreen.fullRoute) {
        MainScreen()
    }
}