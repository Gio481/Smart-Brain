package com.example.smartbrainauthentication.feature.signin.di

import com.example.smartbrainauthentication.presentation.signin.di.SBSignInModule
import com.example.smartbraincomponents.koin.SBBaseFeatureComponent

interface SBSignInFeatureComponent:SBBaseFeatureComponent {
    fun signInModule():SBSignInModule
}