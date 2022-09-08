package com.example.smartbrainauthentication.feature.signin.di

import com.example.smartbrainauthentication.presentation.signin.login.di.SBLogInModule
import com.example.smartbraincomponents.koin.SBBaseFeatureComponent

interface SBSignInFeatureComponent:SBBaseFeatureComponent {
    fun loginModule():SBLogInModule
}