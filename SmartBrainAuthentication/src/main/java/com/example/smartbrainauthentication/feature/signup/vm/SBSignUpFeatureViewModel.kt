package com.example.smartbrainauthentication.feature.signup.vm

import com.example.smartbrainauthentication.feature.signup.screen.SBSignUpFlowScreens
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBSignUpFeatureViewModel(service: SBFlowRouterService) : SBBaseViewModel(service) {

    fun setStartFragment() {
        changeScreen(screen = SBSignUpFlowScreens.PersonalInformation)
    }
}