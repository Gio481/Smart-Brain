package com.example.smartbraincomponents.base

import androidx.lifecycle.ViewModel
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
open class SBBaseViewModel : ViewModel(), KoinComponent {

    val router: SBFlowRouter by inject()

    fun changeScreen(
        screen: SBFlowScreen,
        navigationType: SBNavigationType = SBNavigationType.REPLACE,
    ) {
        router.navigateTo(screen = screen, navigationType = navigationType)
    }

    fun back() {
        router.back()
    }

    fun backTo(screen: SBFlowScreen) {
        router.backTo(screen)
    }
}