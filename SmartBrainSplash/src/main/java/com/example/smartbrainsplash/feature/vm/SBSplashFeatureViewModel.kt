package com.example.smartbrainsplash.feature.vm

import androidx.lifecycle.viewModelScope
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SBSplashFeatureViewModel(
    service: SBFlowRouterService,
    private val introNavigator: SBAppNavigators.Intro,
) : SBBaseViewModel(service) {


    init {
        navigateToSmartBrainIntro()
    }

    private fun navigateToSmartBrainIntro() {
        viewModelScope.launch {
            delay(2500)
            introNavigator.navigateToIntro()
        }
    }
}