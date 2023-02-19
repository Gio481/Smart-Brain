package com.example.smartbrainauthentication.presentation.signin.login.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBSignInViewModel(
    service: SBFlowRouterService,
    private val homeNavigator: SBAppNavigators.Home,
) : SBBaseViewModel(service) {

    fun navigateToHome() {
        homeNavigator.navigateToHome()
    }
}