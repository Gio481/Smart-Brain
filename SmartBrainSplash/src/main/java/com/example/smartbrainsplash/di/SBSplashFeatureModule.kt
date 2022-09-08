package com.example.smartbrainsplash.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainsplash.feature.vm.SBSplashFeatureViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBSplashFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {

    override fun onFeatureModule(): Module = module {
        viewModelOf(::SBSplashFeatureViewModel)
    }
}