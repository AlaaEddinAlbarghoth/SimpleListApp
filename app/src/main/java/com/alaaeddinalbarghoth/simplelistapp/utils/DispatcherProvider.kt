package com.alaaeddinalbarghoth.simplelistapp.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val ui: CoroutineDispatcher
}