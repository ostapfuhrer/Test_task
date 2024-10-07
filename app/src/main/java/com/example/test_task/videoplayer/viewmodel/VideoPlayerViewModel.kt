package com.example.test_task.videoplayer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.main.usecases.ILoadVideosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val loadVideosUseCase: ILoadVideosUseCase
) : ViewModel() {
    private val _videoUrl = MutableLiveData<String?>()
    val videoUrl: LiveData<String?> get() = _videoUrl

    private val _videoList = mutableListOf<String>()
    private var currentVideoIndex = -1

    fun loadVideo(videoId: Long) {
        viewModelScope.launch {
    
            val videoUrl = loadVideosUseCase.getVideoById(videoId)
            _videoUrl.value = videoUrl

            if (!videoUrl.isNullOrEmpty() && !(_videoList.contains(videoUrl))) {
                _videoList.add(videoUrl)
                currentVideoIndex = _videoList.size - 1
            }
        }
    }

    fun playNext() {
        if (currentVideoIndex < _videoList.size - 1) {
            currentVideoIndex++
            _videoUrl.value = _videoList[currentVideoIndex]
        }
    }

    fun playPrevious() {
        if (currentVideoIndex > 0) {
            currentVideoIndex--
            _videoUrl.value = _videoList[currentVideoIndex]
        }
    }
}
