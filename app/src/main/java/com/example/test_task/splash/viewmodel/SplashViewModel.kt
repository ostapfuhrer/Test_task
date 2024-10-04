package com.example.test_task.splash.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.splash.navigation.SplashNavigationActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigationActions: SplashNavigationActions,
) : ViewModel() {
    init {
        Log.d("MyTAG", "SplashViewModel initialized")
        navigateToMain()
    }

    private fun navigateToMain() {
        viewModelScope.launch {
            delay(1000)
            Log.d("MyTAG", "Navigating to Main Screen from SplashViewModel")
            navigationActions.navigateToMain()
        }
    }
}