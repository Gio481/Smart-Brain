package com.example.smartbraincomponents.base

import androidx.lifecycle.ViewModel
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

open class SBBaseViewModel(service: SBFlowRouterService? = null) : ViewModel() {

    val router: SBFlowRouter? = service?.router

    protected fun changeScreen(
        screen: SBFlowScreen,
        navigationType: SBNavigationType = SBNavigationType.REPLACE,
    ) {
        router?.navigateTo(screen = screen, navigationType = navigationType)
    }

    protected fun back() {
        router?.back()
    }

    protected fun backTo(screen: SBFlowScreen) {
        router?.backTo(screen)
    }

    protected fun finishFlow(){
        router?.finishFlow()
    }
}