package com.alaaeddinalbarghoth.simplelistapp.domain

import com.alaaeddinalbarghoth.simplelistapp.domain.repositories.FeedRepository
import okhttp3.ResponseBody
import javax.inject.Inject


class DownloadUseCase @Inject constructor(
    private val feedRepository: FeedRepository
) {
    suspend fun downloadFile(url: String): ResponseBody = feedRepository.downloadFile(url)
}