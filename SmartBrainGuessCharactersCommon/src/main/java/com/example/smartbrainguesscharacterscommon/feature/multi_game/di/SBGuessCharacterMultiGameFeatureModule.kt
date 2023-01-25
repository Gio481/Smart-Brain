package com.example.smartbrainguesscharacterscommon.feature.multi_game.di

import com.example.smartbraincomponents.koin.SBPerFeature
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessCharacterMultiGameFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {
    override fun onFeatureModule() = module{

    }
}
