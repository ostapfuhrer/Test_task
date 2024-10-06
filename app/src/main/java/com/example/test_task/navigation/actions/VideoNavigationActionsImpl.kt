package com.example.test_task.navigation.actions

import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.navigation.navigator.AppNavigator
import com.example.test_task.videoplayer.navigation.IVideoPlayerNavigationActions
import javax.inject.Inject

class VideoNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : IVideoPlayerNavigationActions {

    override suspend fun navigateToVideoPlayer(videoId: String) {
        appNavigator.navigateTo(
            route = Destination.VideoPlayerScreen.withArgs(videoId),
            popUpToRoute = Destination.MainScreen.route,
            inclusive = false,
            isSingleTop = true
        )
    }
}