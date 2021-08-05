package com.alaaeddinalbarghoth.simplelistapp.di

import com.alaaeddinalbarghoth.simplelistapp.utils.CoroutineDispatcherProvider
import com.alaaeddinalbarghoth.simplelistapp.utils.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoroutineDispatcherModule {
    @Binds
    fun bindDispatcher(dispatcherProvider: CoroutineDispatcherProvider): DispatcherProvider
}