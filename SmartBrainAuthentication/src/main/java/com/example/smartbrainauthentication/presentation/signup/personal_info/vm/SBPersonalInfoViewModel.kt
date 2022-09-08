package com.example.smartbrainauthentication.presentation.signup.personal_info.vm

import com.example.smartbrainauthentication.feature.signup.screen.SBSignUpFlowScreens
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBPersonalInfoViewModel(service: SBFlowRouterService) : SBBaseViewModel(service) {

    fun next() {
        changeScreen(screen = SBSignUpFlowScreens.Profile)
    }
}