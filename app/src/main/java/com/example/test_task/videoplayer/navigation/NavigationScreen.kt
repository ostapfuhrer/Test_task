package com.example.test_task.videoplayer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.videoplayer.screen.VideoPlayerScreen

fun NavGraphBuilder.videoPlayerScreen() {
    composable(route = Destination.VideoPlayerScreen.fullRoute) { backStackEntry ->
        val videoId = backStackEntry.arguments?.getString("videoId") ?: return@composable
        VideoPlayerScreen(videoId = videoId)
    }
}