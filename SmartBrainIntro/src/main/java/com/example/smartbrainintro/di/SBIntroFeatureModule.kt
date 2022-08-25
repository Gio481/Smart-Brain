package com.example.smartbrainintro.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainintro.feature.vm.SBIntroFeatureViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBIntroFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {
    override fun onFeatureModule() = module {
        viewModel {
            SBIntroFeatureViewModel(authenticationNavigator = get())
        }
    }
}