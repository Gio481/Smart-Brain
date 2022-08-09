package com.example.smartbrainnavigation.cicerone.flow

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

abstract class SBFlowScreen : SBBaseScreen {
    var animation: SBAnimation = SBAnimation.leftToRight()
        private set

    fun setAnimation(type: SBAnimation) {
        this.animation = type
    }
}