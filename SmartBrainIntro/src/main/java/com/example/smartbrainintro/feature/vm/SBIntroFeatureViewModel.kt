package com.example.smartbrainintro.feature.vm

import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigator
import com.example.smartbraincomponents.base.SBBaseViewModel

class SBIntroFeatureViewModel(
    private val authenticationNavigator: SBAuthenticationNavigator,
) : SBBaseViewModel() {

    fun navigateToSignIn() {
        authenticationNavigator.navigateToSignIn()
    }

    fun navigateToSignUp() {
        authenticationNavigator.navigateToSignUp()
    }
}