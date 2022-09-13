package com.example.smartbrainintro.feature.vm

import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigator
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBIntroFeatureViewModel(
    service:SBFlowRouterService,
    private val authenticationNavigator: SBAuthenticationNavigator,
) : SBBaseViewModel(service) {

    fun navigateToSignIn() {
        authenticationNavigator.navigateToSignIn()
    }

    fun navigateToSignUp() {
        authenticationNavigator.navigateToSignUp()
    }
}