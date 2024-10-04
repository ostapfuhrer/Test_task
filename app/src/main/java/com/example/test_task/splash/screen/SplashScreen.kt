package com.example.test_task.splash.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test_task.R

@Composable
fun SplashScreen() {
    SplashScreenUI()
}

@Composable
private fun SplashScreenUI() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_background),
            contentDescription = "splashScreen_background",
            contentScale = ContentScale.FillBounds
        )
        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
                .size(64.dp, 84.dp),
            painter = painterResource(id = R.drawable.movie_logo),
            contentDescription = "splashScreen_logo",
        )
    }
}

@Composable
@Preview
fun SplashScreenUIPreview() {
    SplashScreenUI()
}
