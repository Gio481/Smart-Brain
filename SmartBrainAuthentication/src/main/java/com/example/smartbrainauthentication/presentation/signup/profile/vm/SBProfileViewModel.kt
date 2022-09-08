package com.example.smartbrainauthentication.presentation.signup.profile.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainhome.navigation.SBHomeNavigator
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBProfileViewModel(
    service: SBFlowRouterService,
    private val homeNavigator: SBHomeNavigator,
) : SBBaseViewModel(service) {

    fun signUp() {
        homeNavigator.navigateToHome()
    }
}