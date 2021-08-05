package com.alaaeddinalbarghoth.simplelistapp.domain.repositories

import okhttp3.ResponseBody

interface FeedRepository {

    suspend fun downloadFile(urlString: String): ResponseBody
}