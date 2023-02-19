package com.example.smartbrainauthentication.feature.signin.screen

import androidx.fragment.app.Fragment
import com.example.smartbrainauthentication.presentation.signin.login.ui.SBSignInFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBSignInFlowScreen : SBFlowScreen() {
    object Main : SBSignInFlowScreen() {
        override fun getFragment(): Fragment = SBSignInFragment()
    }
}