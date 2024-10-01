package com.example.test_task.data.room_database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test_task.data.entities.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}