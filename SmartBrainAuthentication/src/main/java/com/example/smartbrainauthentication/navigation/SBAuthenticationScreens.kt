package com.example.smartbrainauthentication.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainauthentication.feature.signin.ui.SBSignInFeatureFragment
import com.example.smartbrainauthentication.feature.signup.ui.SBSignUpFeatureFragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen

sealed class SBAuthenticationScreens : SBFeatureScreen() {

    object SignIn : SBAuthenticationScreens() {
        override fun getFragment(): Fragment = SBSignInFeatureFragment()
    }

    object SignUp : SBAuthenticationScreens() {
        override fun getFragment(): Fragment = SBSignUpFeatureFragment()
    }
}