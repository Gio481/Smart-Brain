package com.example.smartbrainguessmovies.feature.start.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainguessmovies.feature.start.vm.SBStartGuessMoviesFeatureVm
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBStartGuessMoviesFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {

    override fun onFeatureModule() = module {
        viewModel {
            SBStartGuessMoviesFeatureVm(service = get(featureQualifier))
        }
        injectFlowNavigatorModule(featureQualifier)
    }
}