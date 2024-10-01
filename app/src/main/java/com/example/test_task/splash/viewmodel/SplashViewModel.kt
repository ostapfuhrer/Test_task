package com.example.test_task.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_task.splash.navigation.SplashNavigationActions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val navigationActions: SplashNavigationActions,
) : ViewModel() {

    private fun navigateToMain() {
        viewModelScope.launch {
            navigationActions.navigateToMain()
        }
    }
}