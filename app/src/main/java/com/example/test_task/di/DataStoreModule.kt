package com.example.test_task.di

import com.example.test_task.data.data_store.SettingsDataStore
import com.example.test_task.data.data_store.SettingsDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {
    @Singleton
    @Binds
    abstract fun bindSettingsDataStore(settingsDataStoreImpl: SettingsDataStoreImpl): SettingsDataStore
}