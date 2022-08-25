package com.example.smartbrainsplash.di

import com.example.smartbraincomponents.koin.SBPerFeature

class SBSplashFeatureComponentImpl : SBSplashFeatureComponent {

    override fun featureModule(): SBPerFeature = SBSplashFeatureModule(featureQualifier())

    override fun featureDestroy() {
        featureModule().destroy()
    }
}