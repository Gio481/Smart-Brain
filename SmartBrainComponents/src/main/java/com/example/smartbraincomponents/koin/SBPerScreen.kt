package com.example.smartbraincomponents.koin

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

abstract class SBPerScreen<L : LifecycleOwner> : SBPerScreenModule<L>, LifecycleObserver {
    private lateinit var module: Module

    abstract fun onScreenModule():Module

    override fun inject(lifecycleOwner: L) {
        module = onScreenModule()
        loadKoinModules(module)
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun destroy(lifecycleOwner: LifecycleOwner) {
        unloadKoinModules(module)
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}