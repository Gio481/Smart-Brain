package com.example.smartbrainguesscharacters.feature.details.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainguesscharacters.feature.details.vm.SBGuessCharactersDetailsFeatureVm
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBDetailsFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {
    override fun onFeatureModule() = module {
        viewModel { SBGuessCharactersDetailsFeatureVm(service = get(featureQualifier)) }
        injectFlowNavigatorModule(featureQualifier)
    }
}