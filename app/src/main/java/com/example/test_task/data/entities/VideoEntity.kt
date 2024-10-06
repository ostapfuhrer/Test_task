package com.example.test_task.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Json

@Entity(tableName = "videos")
data class VideoEntity(
    @PrimaryKey(autoGenerate = true) val videoId: Long = 0,
    val title: String,
    val description: String,
    @Json(name = "sources") val url: List<String>,
    val subtitle: String,
    val thumb: String
)

class Converters {
    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return value?.joinToString(",")
    }

    @TypeConverter
    fun toStringList(value: String?): List<String> {
        return value?.split(",") ?: emptyList()
    }
}