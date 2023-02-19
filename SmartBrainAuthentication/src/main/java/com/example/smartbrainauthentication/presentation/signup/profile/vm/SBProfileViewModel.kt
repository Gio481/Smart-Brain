package com.example.smartbrainauthentication.presentation.signup.profile.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBProfileViewModel(
    service: SBFlowRouterService,
    private val homeNavigator: SBAppNavigators.Home,
) : SBBaseViewModel(service) {

    fun signUp() {
        homeNavigator.navigateToHome()
    }
}