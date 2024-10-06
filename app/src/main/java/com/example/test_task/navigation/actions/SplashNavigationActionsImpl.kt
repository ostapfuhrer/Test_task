package com.example.test_task.navigation.actions

import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.navigation.navigator.AppNavigator
import com.example.test_task.splash.navigation.SplashNavigationActions
import javax.inject.Inject

class SplashNavigationActionsImpl @Inject constructor(
    private val appNavigator: AppNavigator
) : SplashNavigationActions {

    override suspend fun navigateToMain() {
        appNavigator.navigateTo(
            route = Destination.MainScreen.route,
            popUpToRoute = Destination.SplashScreen.route,
            inclusive = true,
            isSingleTop = true
        )
    }
}