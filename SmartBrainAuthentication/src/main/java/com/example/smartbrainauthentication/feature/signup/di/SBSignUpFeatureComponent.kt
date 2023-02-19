package com.example.smartbrainauthentication.feature.signup.di

import com.example.smartbrainauthentication.presentation.signup.personal_info.di.SBPersonalInfoModule
import com.example.smartbrainauthentication.presentation.signup.profile.di.SBProfileModule
import com.example.smartbraincomponents.koin.SBBaseFeatureComponent

interface SBSignUpFeatureComponent : SBBaseFeatureComponent {
    fun personalInfoModule(): SBPersonalInfoModule
    fun profileModule(): SBProfileModule
}