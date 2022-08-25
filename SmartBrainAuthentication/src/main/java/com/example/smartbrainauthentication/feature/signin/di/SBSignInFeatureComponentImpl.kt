package com.example.smartbrainauthentication.feature.signin.di

import com.example.smartbrainauthentication.feature.signin.ui.SBSignInFeatureFragment
import com.example.smartbrainauthentication.presentation.signin.di.SBSignInModule
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbraincomponents.util.getFeatureQualifier
import org.koin.core.qualifier.StringQualifier

class SBSignInFeatureComponentImpl : SBSignInFeatureComponent {
    override fun signInModule(): SBSignInModule = SBSignInModule(featureQualifier())

    override fun featureModule(): SBPerFeature = SBSignInFeatureModule(featureQualifier())

    override fun featureDestroy() {
        featureModule().destroy()
    }

    override fun featureQualifier(): StringQualifier = SBSignInFeatureFragment::class.java.getFeatureQualifier()
}