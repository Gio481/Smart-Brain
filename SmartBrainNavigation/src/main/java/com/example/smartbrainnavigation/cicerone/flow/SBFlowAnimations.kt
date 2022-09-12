package com.example.smartbrainnavigation.cicerone.flow

import com.example.smartbrainnavigation.R
import com.example.smartbrainnavigation.cicerone.SBAnimation

data class SBFlowAnimations(
    val enterTransition: SBAnimation = SBAnimation.Resources(R.anim.enter_from_rigth),
    val exitTransition: SBAnimation = SBAnimation.Resources(R.anim.fade_out),
    val reEnterTransition: SBAnimation = SBAnimation.Resources(R.anim.fade_in),
    val reExitTransition: SBAnimation = SBAnimation.Resources(R.anim.exit_to_right),
)
