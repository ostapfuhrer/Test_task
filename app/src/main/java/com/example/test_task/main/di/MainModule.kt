package com.example.test_task.main.di

import com.example.test_task.main.usecases.ILoadVideosUseCase
import com.example.test_task.main.usecases.LoadVideosUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MainModule {
    @Binds
    abstract fun bindCreateBoardUseCase(loadVideosUseCaseImpl: LoadVideosUseCaseImpl): ILoadVideosUseCase
}