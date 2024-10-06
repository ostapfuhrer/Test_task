package com.example.test_task.videoplayer.screen

import androidx.annotation.OptIn
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.test_task.videoplayer.viewmodel.VideoPlayerViewModel

@Composable
fun VideoPlayerScreen(
    videoId: String,
    videoPlayerViewModel: VideoPlayerViewModel = hiltViewModel()
) {
    LaunchedEffect(videoId) {
        videoPlayerViewModel.loadVideo(videoId.toLong())
    }

    val videoUrl by videoPlayerViewModel.videoUrl.observeAsState()

    // ExoPlayer
    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }

    videoUrl?.let { url ->
        DisposableEffect(url) {
            val mediaItem = MediaItem.fromUri(url)
            player.setMediaItem(mediaItem)
            player.prepare()
            player.playWhenReady = true

            onDispose {
                player.release()
            }
        }
    }

    VideoPlayerView(player = player)
}

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayerView(player: ExoPlayer) {
    val context = LocalContext.current
    AndroidView(
        factory = {
            PlayerView(context).apply {
                this.player = player
                setShowNextButton(true)
                setShowPreviousButton(true)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(16 / 9f)
    )
}
