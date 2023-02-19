package com.example.smartbrainhome.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainhome.feature.vm.SBHomeFeatureViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBHomeFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {

    override fun onFeatureModule() = module {
        viewModel {
            SBHomeFeatureViewModel()
        }
    }
}