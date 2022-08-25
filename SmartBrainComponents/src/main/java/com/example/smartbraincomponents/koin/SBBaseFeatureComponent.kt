package com.example.smartbraincomponents.koin

import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier

interface SBBaseFeatureComponent {
    fun featureModule(): SBPerFeature
    fun featureInject(featureModule: (Module) -> Unit={}) = featureModule().inject(featureModule)
    fun featureDestroy()
    fun featureQualifier() = StringQualifier(this::class.toString())
}