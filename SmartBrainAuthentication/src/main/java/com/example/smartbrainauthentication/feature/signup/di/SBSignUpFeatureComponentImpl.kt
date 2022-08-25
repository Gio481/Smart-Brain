package com.example.smartbrainauthentication.feature.signup.di

import com.example.smartbrainauthentication.feature.signup.ui.SBSignUpFeatureFragment
import com.example.smartbrainauthentication.presentation.signup.di.SBSignUpModule
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbraincomponents.util.getFeatureQualifier
import org.koin.core.qualifier.StringQualifier

class SBSignUpFeatureComponentImpl : SBSignUpFeatureComponent {

    override fun signUpModule(): SBSignUpModule = SBSignUpModule(featureQualifier())
    override fun featureModule(): SBPerFeature = SBSignUpFeatureModule(featureQualifier())
    override fun featureDestroy() {
        featureModule().destroy()
    }
    override fun featureQualifier(): StringQualifier = SBSignUpFeatureFragment::class.java.getFeatureQualifier()
}