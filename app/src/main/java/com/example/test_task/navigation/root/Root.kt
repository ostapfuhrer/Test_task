package com.example.test_task.navigation.root

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.test_task.main.navigation.mainScreen
import com.example.test_task.navigation.LocalNavController
import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.navigation.getNavController
import com.example.test_task.navigation.navigator.NavigationIntent
import com.example.test_task.navigation.viewmodel.NavigationViewModel
import com.example.test_task.splash.navigation.splashScreen
import com.example.test_task.splash.viewmodel.SplashViewModel
import com.example.test_task.videoplayer.navigation.videoPlayerScreen
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Root(
    navigationViewModel: NavigationViewModel = hiltViewModel(),
    splashViewModel: SplashViewModel = hiltViewModel(),
) {
    CompositionLocalProvider(
        LocalNavController provides getNavController()
    ) {
        NavigationEffects(
            navHostController = getNavController(),
            navigationFlow = navigationViewModel.navigationFlow,
        )

        NavHost(
            navController = getNavController(),
            startDestination = Destination.SplashScreen.fullRoute
        ) {
            Log.d("MyTAG", "Root() called")
            splashScreen()
            mainScreen()
            videoPlayerScreen()
        }
    }
}

@Composable
fun NavigationEffects(
    navHostController: NavHostController,
    navigationFlow: SharedFlow<NavigationIntent>
) {
    LaunchedEffect(navHostController) {
        navigationFlow.collect { intent ->
            Log.d("MyTAG", "Navigation intent collected: $intent")
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
                    Log.d("MyTAG", "Navigating to route: ${intent.route}")
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}