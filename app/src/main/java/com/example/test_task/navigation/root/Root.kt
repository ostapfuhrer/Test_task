package com.example.test_task.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.test_task.navigation.LocalNavController
import com.example.test_task.navigation.destinations.Destination
import com.example.test_task.navigation.getNavController
import com.example.test_task.navigation.navigator.NavigationIntent
import com.example.test_task.navigation.viewmodel.NavigationViewModel
import com.example.test_task.splash.navigation.splashScreen
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Root(
    navigationViewModel: NavigationViewModel = hiltViewModel(),
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
            splashScreen()
            //mainScreen()
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
            when (intent) {
                is NavigationIntent.NavigateBack -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo -> {
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