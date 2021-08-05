package com.alaaeddinalbarghoth.simplelistapp.data.repositories

import com.alaaeddinalbarghoth.simplelistapp.data.remote.FeedApiService
import com.alaaeddinalbarghoth.simplelistapp.domain.repositories.FeedRepository
import com.alaaeddinalbarghoth.simplelistapp.utils.DispatcherProvider
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody

class FeedRepositoryImpl(
    private val feedApiService: FeedApiService,
    private val dispatcher: DispatcherProvider
) : FeedRepository {

    override suspend fun downloadFile(urlString: String): ResponseBody {
        return withContext(dispatcher.io) {
            feedApiService.downloadFile(urlString)
        }
    }

}