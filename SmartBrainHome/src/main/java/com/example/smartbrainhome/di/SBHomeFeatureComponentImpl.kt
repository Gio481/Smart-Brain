package com.example.smartbrainhome.di

import com.example.smartbraincomponents.koin.SBPerFeature

class SBHomeFeatureComponentImpl : SBHomeFeatureComponent {

    override fun featureModule(): SBPerFeature {
        return SBHomeFeatureModule(featureQualifier())
    }

    override fun featureDestroy() {
        featureModule().destroy()
    }
}