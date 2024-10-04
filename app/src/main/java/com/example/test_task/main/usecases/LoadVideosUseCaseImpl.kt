package com.example.test_task.main.usecases

import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.repository.VideoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadVideosUseCaseImpl @Inject constructor(
    private val videoRepository: VideoRepository
) : ILoadVideosUseCase {
    override fun observeVideos(): Flow<List<VideoEntity>> {
        return videoRepository.observeVideos()
    }

    override suspend fun fetchAndCacheVideos() {
        videoRepository.fetchAndCacheVideos()
    }
}