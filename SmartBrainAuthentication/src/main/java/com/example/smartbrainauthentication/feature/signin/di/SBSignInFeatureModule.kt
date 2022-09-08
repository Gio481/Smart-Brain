package com.example.smartbrainauthentication.feature.signin.di

import com.example.smartbrainauthentication.feature.signin.vm.SBSignInFeatureViewModel
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBSignInFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {
    override fun onFeatureModule() = module {
        viewModel {
            SBSignInFeatureViewModel(service = get(featureQualifier))
        }
        injectFlowNavigatorModule(featureQualifier)
    }
}