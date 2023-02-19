package com.example.smartbraincomponents.koin

import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier

abstract class SBPerFeature {

    abstract val featureQualifier: StringQualifier
    private var _module: Module? = null

    abstract fun onFeatureModule(): Module

    fun inject(featureModule: (Module) -> Unit) {
        if (_module == null) {
            _module = onFeatureModule()
            featureModule.invoke(_module!!)
            _module?.let { loadKoinModules(it) }
        }
    }

    fun destroy() {
        _module?.let { unloadKoinModules(it) }
    }
}