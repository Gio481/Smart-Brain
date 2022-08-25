package com.example.smartbrainauthentication.feature.signup.screen

import androidx.fragment.app.Fragment
import com.example.smartbrainauthentication.presentation.signup.ui.SBSignUpFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBSignUpFlowScreens : SBFlowScreen() {
    object Main : SBSignUpFlowScreens() {
        override fun getFragment(): Fragment = SBSignUpFragment()
    }
}