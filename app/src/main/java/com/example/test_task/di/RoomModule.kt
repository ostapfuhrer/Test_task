package com.example.test_task.di

import android.content.Context
import androidx.room.Room
import com.example.test_task.data.room_database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, AppDatabase::class.java, "testApplication-db").build()

    @Provides
    fun provideUsersDao(appDatabase: AppDatabase) = appDatabase.videoDao()
}