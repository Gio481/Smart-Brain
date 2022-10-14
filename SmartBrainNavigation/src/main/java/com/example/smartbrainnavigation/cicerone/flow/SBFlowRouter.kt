package com.example.smartbrainnavigation.cicerone.flow

import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBFlowRouter(private val featureRouter: SBFeatureRouter) : SBBaseRouter() {

    fun navigateTo(
        screen: SBFlowScreen,
        navigationType: SBNavigationType = SBNavigationType.ADD,
        animation: SBFlowAnimations = SBFlowAnimations(),
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