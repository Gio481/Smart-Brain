package com.example.smartbrainnavigation.cicerone.flow

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.base.SBRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBFlowRouter(private val featureRouter: SBFeatureRouter) : SBRouter() {

    fun navigateTo(
        screen: SBFlowScreen,
        navigationType: SBNavigationType = SBNavigationType.ADD,
        animation: SBAnimation = SBAnimation.leftToRight(),
    ) {
        screen.setAnimation(animation)
        when (navigationType) {
            SBNavigationType.ADD -> executeAdd(screen)
            SBNavigationType.REPLACE -> executeReplace(screen)
            SBNavigationType.REPLACE_AND_POP -> {
                executePop()
                executeReplace(screen)
            }
            else -> throw RuntimeException("$navigationType is not handled in SBFlowRouter")
        }
    }

    override fun finishFlow() {
        featureRouter.finishFlow()
    }
}