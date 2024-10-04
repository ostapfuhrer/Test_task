package com.example.test_task.data.remote

import com.example.test_task.data.models.response.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface VideoApiService {
    @GET
    suspend fun getVideoList(@Url url: String = "https://gist.githubusercontent.com/ostapfuhrer/7c77beb4c7a6e127efd23b6f0c980863/raw/8a293ac3e2efd240ce84ecc52ae343d6ce7fc32e/gistfilemovies.txt"): Response<VideoResponse>
}