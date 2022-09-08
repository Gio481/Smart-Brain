package com.example.smartbrainauthentication.feature.signup.di

import com.example.smartbrainauthentication.feature.signup.ui.SBSignUpFeatureFragment
import com.example.smartbrainauthentication.presentation.signup.personal_info.di.SBPersonalInfoModule
import com.example.smartbrainauthentication.presentation.signup.profile.di.SBProfileModule
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbraincomponents.extension.getFeatureQualifier
import org.koin.core.qualifier.StringQualifier

class SBSignUpFeatureComponentImpl : SBSignUpFeatureComponent {

    override fun personalInfoModule(): SBPersonalInfoModule = SBPersonalInfoModule(featureQualifier())
    override fun profileModule(): SBProfileModule = SBProfileModule(featureQualifier())
    override fun featureModule(): SBPerFeature = SBSignUpFeatureModule(featureQualifier())
    override fun featureDestroy() = featureModule().destroy()
    override fun featureQualifier(): StringQualifier = SBSignUpFeatureFragment::class.java.getFeatureQualifier()
}