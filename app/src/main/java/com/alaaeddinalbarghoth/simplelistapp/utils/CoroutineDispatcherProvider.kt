package com.alaaeddinalbarghoth.simplelistapp.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CoroutineDispatcherProvider @Inject constructor() : DispatcherProvider {

    override val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override val ui: CoroutineDispatcher
        get() = Dispatchers.Main
}