package com.example.test_task.navigation.di

import com.example.test_task.navigation.actions.SplashNavigationActionsImpl
import com.example.test_task.navigation.navigator.AppNavigator
import com.example.test_task.navigation.navigator.AppNavigatorImpl
import com.example.test_task.splash.navigation.SplashNavigationActions
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {
    @Singleton
    @Binds
    abstract fun bindAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator

    @Singleton
    @Binds
    abstract fun bindSplashNavigationActions(
        splashNavigationActions: SplashNavigationActionsImpl
    ): SplashNavigationActions
}
