package com.alaaeddinalbarghoth.simplelistapp.di

import com.alaaeddinalbarghoth.simplelistapp.data.remote.FeedApiService
import com.alaaeddinalbarghoth.simplelistapp.data.repositories.FeedRepositoryImpl
import com.alaaeddinalbarghoth.simplelistapp.domain.repositories.FeedRepository
import com.alaaeddinalbarghoth.simplelistapp.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Singleton
    @Provides
    fun provideFeedRepository(
        feedApiService: FeedApiService,
        dispatcherProvider: DispatcherProvider
    ): FeedRepository =
        FeedRepositoryImpl(
            feedApiService,
            dispatcherProvider
        )
}