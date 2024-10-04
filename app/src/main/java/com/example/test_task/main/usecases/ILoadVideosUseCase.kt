package com.example.test_task.main.usecases

import com.example.test_task.data.entities.VideoEntity
import kotlinx.coroutines.flow.Flow

interface ILoadVideosUseCase {
     fun observeVideos(): Flow<List<VideoEntity>>
     suspend fun fetchAndCacheVideos()
}