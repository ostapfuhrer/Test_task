package com.example.test_task.videoplayer.navigation

interface IVideoPlayerNavigationActions {
    suspend fun navigateToVideoPlayer(videoId: String)
}