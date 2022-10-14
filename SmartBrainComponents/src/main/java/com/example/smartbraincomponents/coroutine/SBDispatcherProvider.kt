package com.example.smartbraincomponents.coroutine

import kotlinx.coroutines.CoroutineDispatcher

interface SBDispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}