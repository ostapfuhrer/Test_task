package com.example.test_task.main.composable

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_task.R
import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.main.constants.Constants.BASE_IMAGE_URL

@Composable
fun VideoCard(video: VideoEntity, onClick: () -> Unit) {
    val imageUrl = "$BASE_IMAGE_URL${video.thumb}"

    val cardModifier = Modifier
        .fillMaxWidth()
        .padding(4.dp)
        .clickable(onClick = onClick)

    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = cardModifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = video.title, style = MaterialTheme.typography.titleLarge)

            Text(
                text = video.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = video.subtitle,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Thumbnail for ${video.title}",
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(R.drawable.ic_launcher_foreground),
                    onError = {
                        Log.e(
                            "Image Load Error",
                            "Failed to load image: ${it.result.throwable.message}"
                        )
                    }
                )
                Icon(
                    painter = painterResource(R.drawable.ic_play_button),
                    contentDescription = "Play",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(48.dp)
                        .padding(8.dp),
                    tint = Color.White
                )
            }
        }
    }
}