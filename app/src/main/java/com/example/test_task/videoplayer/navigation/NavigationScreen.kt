package com.example.test_task.videoplayer.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.test_task.main.screen.MainScreen
import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.videoplayer.screen.VideoPlayerScreen

fun NavGraphBuilder.videoPlayerScreen() {
    composable(route = Destination.VideoPlayerScreen.fullRoute) {
      //  VideoPlayerScreen()
    }
}