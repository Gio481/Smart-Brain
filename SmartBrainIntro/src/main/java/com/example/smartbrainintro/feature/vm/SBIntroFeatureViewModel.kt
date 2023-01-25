package com.example.smartbrainintro.feature.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBIntroFeatureViewModel(
    service:SBFlowRouterService,
    private val authenticationNavigator: SBAppNavigators.Authentication,
) : SBBaseViewModel(service) {

    fun navigateToSignIn() {
        authenticationNavigator.navigateToSignIn()
    }

    fun navigateToSignUp() {
        authenticationNavigator.navigateToSignUp()
    }
}