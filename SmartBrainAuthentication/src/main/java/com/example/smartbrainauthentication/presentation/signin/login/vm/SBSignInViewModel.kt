package com.example.smartbrainauthentication.presentation.signin.login.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainhome.navigation.SBHomeNavigator
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBSignInViewModel(
    service: SBFlowRouterService,
    private val homeNavigator: SBHomeNavigator,
) : SBBaseViewModel(service) {

    fun navigateToHome() {
        homeNavigator.navigateToHome()
    }
}