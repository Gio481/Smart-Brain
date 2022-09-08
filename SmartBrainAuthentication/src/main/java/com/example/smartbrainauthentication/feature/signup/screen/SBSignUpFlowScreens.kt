package com.example.smartbrainauthentication.feature.signup.screen

import androidx.fragment.app.Fragment
import com.example.smartbrainauthentication.presentation.signup.personal_info.ui.SBPersonalInfoFragment
import com.example.smartbrainauthentication.presentation.signup.profile.ui.SBProfileFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBSignUpFlowScreens : SBFlowScreen() {
    object PersonalInformation : SBSignUpFlowScreens() {
        override fun getFragment(): Fragment = SBPersonalInfoFragment()
    }

    object Profile : SBSignUpFlowScreens() {
        override fun getFragment(): Fragment = SBProfileFragment()
    }
}