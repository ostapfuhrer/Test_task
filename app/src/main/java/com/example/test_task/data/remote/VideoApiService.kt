package com.example.test_task.data.remote

import com.example.test_task.data.models.response.VideoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface VideoApiService {
    @GET
    suspend fun getVideoList(@Url url: String = "https://gist.githubusercontent.com/ostapfuhrer/e241e0f5bb9295491e9ecbca92905be4/raw/733a5022234cd4401d43769fb308e93924057bf9/gistfilemovies.txt"): Response<VideoResponse>
}