package com.example.test_task.main.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.test_task.main.composable.VideoCard
import com.example.test_task.main.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = hiltViewModel(),
) {
    val videoList by mainViewModel.videoList.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(vertical = 64.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(videoList) { video ->
            VideoCard(video = video) {
                mainViewModel.navigateToVideoPlayer(video.videoId)
            }
            Log.d("MyTAG", "Video: $video")
        }
    }
}
