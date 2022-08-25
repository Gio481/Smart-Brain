package com.example.smartbrainauthentication.feature.signup.di

import com.example.smartbrainauthentication.feature.signup.vm.SBSignUpFeatureViewModel
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBSignUpFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {
    override fun onFeatureModule() = module {
        injectFlowNavigatorModule()
        viewModel {
            SBSignUpFeatureViewModel()
        }
    }
}