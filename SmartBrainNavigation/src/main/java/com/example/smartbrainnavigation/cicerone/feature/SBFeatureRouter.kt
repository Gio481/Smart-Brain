package com.example.smartbrainnavigation.cicerone.feature

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter

class SBFeatureRouter : SBBaseRouter() {

    fun navigateTo(
        screen: SBFeatureScreen,
        navigationType: SBNavigationType = SBNavigationType.ADD,
        animation: SBAnimation = SBAnimation.bottomToTop(),
    ) {
        navigate(screen, navigationType, animation)
    }

    private fun navigate(
        screen: SBFeatureScreen,
        navigationType: SBNavigationType = SBNavigationType.ADD,
        animation: SBAnimation,
    ) {
        screen.setAnimation(animation)
        when (navigationType) {
            SBNavigationType.ADD -> executeAdd(screen)
            SBNavigationType.REPLACE -> executeReplace(screen)
            SBNavigationType.ADD_AND_POP -> {
                executePop()
                executeAdd(screen)
            }
            SBNavigationType.REPLACE_AND_POP -> {
                executePop()
                executeReplace(screen)
            }
            SBNavigationType.REPLACE_AND_CLEAR -> {
                executeClear()
                executeReplace(screen)
            }
        }
    }

    override fun finishFlow() {
        back()
    }
}