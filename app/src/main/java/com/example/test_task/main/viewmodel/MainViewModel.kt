package com.example.test_task.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.main.usecases.ILoadVideosUseCase
import com.example.test_task.videoplayer.navigation.IVideoPlayerNavigationActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loadVideosUseCase: ILoadVideosUseCase,
    private val videoNavigationActions: IVideoPlayerNavigationActions
) : ViewModel() {
    private val _videoList = MutableStateFlow<List<VideoEntity>>(emptyList())
    val videoList: StateFlow<List<VideoEntity>> = _videoList

    init {
        Log.d("MyTAG", "MainViewModel initialized")
        observeVideos()
        fetchAndCache()
    }

    private fun fetchAndCache() {
        viewModelScope.launch {
            loadVideosUseCase.fetchAndCacheVideos()
        }
    }

    private fun observeVideos() {
        viewModelScope.launch {
            loadVideosUseCase.observeVideos().collect { videos ->
                _videoList.value = videos
                Log.d("MyTAG", "Videos loaded: ${videos.size}")
            }
        }
    }

    fun navigateToVideoPlayer(
        videoId: Long,
    ) {
        viewModelScope.launch {
            videoNavigationActions.navigateToVideoPlayer(videoId.toString())
        }
    }
}