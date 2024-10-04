package com.example.test_task.main.composable

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.test_task.R
import com.example.test_task.data.entities.VideoEntity

@Composable
fun VideoCard(video: VideoEntity) {
    val baseImageUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/"
    val imageUrl = remember(video) { baseImageUrl + video.thumb }
    Card(
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = video.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(4.dp))

            Text(text = video.description, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = video.subtitle, style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(4.dp))
            Log.d("Image URL", "Image url = $imageUrl")
            AsyncImage(
                model = imageUrl,
                contentDescription = "Thumbnail for ${video.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_launcher_foreground),
                onError = {
                    Log.e(
                        "Image Load Error",
                        "Failed to load image: ${it.result.throwable.message}"
                    )
                }
            )
        }
    }
}