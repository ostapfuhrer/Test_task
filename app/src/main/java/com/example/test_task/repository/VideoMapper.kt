package com.example.test_task.repository

import com.example.test_task.data.entities.VideoEntity
import com.example.test_task.data.models.Category

object VideoMapper {
    //Map response model to entity
    fun mapCategoriesToVideoEntities(categories: List<Category>): List<VideoEntity> {
        return categories.flatMap { category ->
            category.videos.map { video ->
                VideoEntity(
                    videoId = video.videoId,
                    title = video.title,
                    description = video.description,
                    url = video.url,
                    subtitle = video.subtitle,
                    thumb = video.thumb
                )
            }
        }
    }
}