package com.example.smartbrainnavigation.cicerone.flow

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

abstract class SBFlowScreen : SBBaseScreen {
    var animation: SBFlowAnimations = SBFlowAnimations()
        private set

    fun setAnimation(type: SBFlowAnimations) {
        this.animation = type
    }
}