package com.example.smartbrainguesscharacters.feature.details.di

import com.example.smartbraincomponents.extension.getFeatureQualifier
import com.example.smartbrainguesscharacters.feature.details.ui.SBGuessCharactersDetailsFeatureFragment

class SBDetailsFeatureComponentImpl : SBDetailsFeatureComponent {
//    override fun detailsFlowModule() = SBDetailsFlowModule(featureQualifier())

    override fun featureModule() = SBDetailsFeatureModule(featureQualifier())

    override fun featureDestroy() {
        featureModule().destroy()
    }

    override fun featureQualifier() =
        SBGuessCharactersDetailsFeatureFragment::class.java.getFeatureQualifier()
}