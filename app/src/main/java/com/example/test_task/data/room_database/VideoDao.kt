package com.example.test_task.data.room_database

import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

interface VideoDao {
  //  @Insert(onConflict = OnConflictStrategy.REPLACE)
  //  suspend fun insertAll(videos: List<VideoEntity>)
//
  //  @Query("SELECT * FROM videos")
  //  fun getAllVideos(): Flow<List<VideoEntity>>
}