package com.alaaeddinalbarghoth.simplelistapp.di

import com.alaaeddinalbarghoth.simplelistapp.presentation.adapter.FeedsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {

    @Provides
    @Singleton
    fun provideFeedsAdapter(
    ): FeedsAdapter =
        FeedsAdapter()

}