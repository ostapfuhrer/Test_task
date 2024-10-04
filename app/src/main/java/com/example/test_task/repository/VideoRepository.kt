package com.example.test_task.repository

import com.example.test_task.data.entities.VideoEntity
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun fetchAndCacheVideos()
    fun observeVideos(): Flow<List<VideoEntity>>
}