package com.example.smartbrainthemaze.feature.play.di

import com.example.smartbraincomponents.extension.getFeatureQualifier
import com.example.smartbraincomponents.koin.SBBaseFeatureComponent
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainthemaze.feature.play.ui.FeatureUI
import org.koin.core.qualifier.StringQualifier

class FeatureComponentImpl:FeatureComponent {
    override fun featureModule(): SBPerFeature  = FeatureModule(featureQualifier())
    override fun featureQualifier() = FeatureUI::class.java.getFeatureQualifier()
    override fun featureDestroy() {
        featureModule().destroy()
    }
}