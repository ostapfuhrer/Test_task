package com.example.test_task.repository

import android.util.Log
import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.data.models.response.VideoResponse
import com.example.test_task.data.remote.VideoApiService
import com.example.test_task.data.room_database.VideoDao
import com.example.test_task.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val videoApiService: VideoApiService,
    private val videoDao: VideoDao,
    @IODispatcher private val dispatcherIo: CoroutineDispatcher,
) : VideoRepository {
    override suspend fun fetchAndCacheVideos() {
        if (isVideosAlreadyCached()) {
            return
        }
        val response = fetchVideosFromApi() ?: return
        cacheVideos(response)
    }

    private suspend fun isVideosAlreadyCached(): Boolean {
        val existingVideos = videoDao.getAllVideos().first()
        return existingVideos.isNotEmpty()
    }

    private suspend fun fetchVideosFromApi(): Response<VideoResponse>? {
        return try {
            withContext(dispatcherIo) { videoApiService.getVideoList() }
        } catch (e: Exception) {
            Log.e("MyTAG", "Error fetching videos from API", e)
            null
        }
    }

    private suspend fun cacheVideos(response: Response<VideoResponse>) {
        if (response.isSuccessful) {
            val categories = response.body()?.categories ?: emptyList()
            val videoEntities = VideoMapper.mapCategoriesToVideoEntities(categories)
            videoDao.insertAllVideos(videoEntities)
        } else {
            Log.e("MyTAG", "API Response was not successful: ${response.message()}")
        }
    }

    override fun observeVideos(): Flow<List<VideoEntity>> {
        return videoDao.getAllVideos()
    }
}
