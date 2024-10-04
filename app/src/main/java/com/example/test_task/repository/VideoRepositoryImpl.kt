package com.example.test_task.repository

import android.util.Log
import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.data.remote.VideoApiService
import com.example.test_task.data.room_database.VideoDao
import com.example.test_task.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val videoApiService: VideoApiService,
    private val videoDao: VideoDao,
    @IODispatcher private val dispatcherIo: CoroutineDispatcher,
) : VideoRepository {
    override suspend fun fetchAndCacheVideos() {
        val response = withContext(dispatcherIo) { videoApiService.getVideoList() }
        if (response.isSuccessful) {
            val categories = response.body()?.categories ?: emptyList()
            Log.d("MyTAG", "Response body: ${response.body()?.categories.toString()}")
            Log.d("MyTAG", "categories=${categories.size}")
            val videoEntities = categories.flatMap { category ->
                category.videos.map { video ->
                    VideoEntity(
                        title = video.title,
                        description = video.description,
                        url = video.url,
                        subtitle = video.subtitle,
                        thumb = video.thumb
                    )
                }
            }
            videoDao.insertAllVideos(videoEntities)
        }
    }

    override fun observeVideos(): Flow<List<VideoEntity>> {
        return videoDao.getAllVideos()
    }
}
