package com.example.smartbrainnavigation.cicerone.feature

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

abstract class SBFeatureScreen : SBBaseScreen {
    var animation: SBAnimation = SBAnimation.bottomToTop()
        private set

    fun setAnimation(type: SBAnimation) {
        this.animation = type
    }
}