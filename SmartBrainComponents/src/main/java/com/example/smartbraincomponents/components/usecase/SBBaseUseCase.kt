package com.example.smartbraincomponents.components.usecase

import com.example.smartbraincomponents.coroutine.SBDispatcherProvider
import com.example.smartbraincomponents.coroutine.SBDispatcherProviderImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

abstract class SBBaseUseCase<out T, in P> {

    private val dispatcherProvider by inject<SBDispatcherProvider>(SBDispatcherProviderImpl::class.java)

    protected abstract suspend fun operation(params: P? = null): T

    suspend fun execute(params: P? = null, dispatcher: CoroutineDispatcher = dispatcherProvider.io): T {
        return withContext(dispatcher) {
            operation(params)
        }
    }
}