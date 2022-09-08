package com.example.smartbrainauthentication.feature.signin.di

import com.example.smartbrainauthentication.feature.signin.ui.SBSignInFeatureFragment
import com.example.smartbrainauthentication.presentation.signin.login.di.SBLogInModule
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbraincomponents.extension.getFeatureQualifier
import org.koin.core.qualifier.StringQualifier

class SBSignInFeatureComponentImpl : SBSignInFeatureComponent {

    override fun loginModule(): SBLogInModule = SBLogInModule(featureQualifier())
    override fun featureModule(): SBPerFeature = SBSignInFeatureModule(featureQualifier())
    override fun featureDestroy() = featureModule().destroy()
    override fun featureQualifier(): StringQualifier = SBSignInFeatureFragment::class.java.getFeatureQualifier()
}