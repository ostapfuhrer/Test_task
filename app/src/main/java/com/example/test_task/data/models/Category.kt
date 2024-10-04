package com.example.test_task.data.models

import com.example.test_task.data.entities.VideoEntity

data class Category(
    val name: String,
    val videos: List<VideoEntity>
)
