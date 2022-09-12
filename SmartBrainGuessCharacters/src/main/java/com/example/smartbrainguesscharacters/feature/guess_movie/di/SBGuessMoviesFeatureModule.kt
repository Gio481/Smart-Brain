package com.example.smartbrainguesscharacters.feature.guess_movie.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainguesscharacters.feature.guess_movie.vm.SBGuessMoviesFeatureVm
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessMoviesFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {

    override fun onFeatureModule() = module {
        viewModel { SBGuessMoviesFeatureVm(service = get(featureQualifier)) }
        injectFlowNavigatorModule(featureQualifier)
    }
}