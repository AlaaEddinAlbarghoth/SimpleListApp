package com.alaaeddinalbarghoth.simplelistapp.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface FeedApiService {

    @GET
    @Streaming
    suspend fun downloadFile(@Url link: String): ResponseBody
}