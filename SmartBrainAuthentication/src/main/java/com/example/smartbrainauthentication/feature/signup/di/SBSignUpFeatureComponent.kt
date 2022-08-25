package com.example.smartbrainauthentication.feature.signup.di

import com.example.smartbrainauthentication.presentation.signup.di.SBSignUpModule
import com.example.smartbraincomponents.koin.SBBaseFeatureComponent

interface SBSignUpFeatureComponent : SBBaseFeatureComponent {
    fun signUpModule(): SBSignUpModule
}