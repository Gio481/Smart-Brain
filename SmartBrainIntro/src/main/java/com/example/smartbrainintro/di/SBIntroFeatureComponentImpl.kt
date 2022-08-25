package com.example.smartbrainintro.di

import com.example.smartbraincomponents.koin.SBPerFeature

class SBIntroFeatureComponentImpl : SBIntroFeatureComponent {
    override fun featureModule(): SBPerFeature = SBIntroFeatureModule(featureQualifier())

    override fun featureDestroy() {
        featureModule().destroy()
    }
}