package com.example.smartbrainauthentication.feature.signin.vm

import com.example.smartbrainauthentication.feature.signin.screen.SBSignInFlowScreen
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBSignInFeatureViewModel(service:SBFlowRouterService):SBBaseViewModel(service) {
    fun setStartFragment(){
        changeScreen(screen = SBSignInFlowScreen.Main)
    }
}