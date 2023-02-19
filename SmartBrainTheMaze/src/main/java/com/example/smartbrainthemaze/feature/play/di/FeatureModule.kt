package com.example.smartbrainthemaze.feature.play.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainthemaze.feature.play.vm.FeatureVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class FeatureModule(override val featureQualifier: StringQualifier) :SBPerFeature() {
    override fun onFeatureModule() = module{

        viewModel { FeatureVm(service = get(featureQualifier)) }

    }
}