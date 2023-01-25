package com.example.smartbrainintro.navigation

import com.example.smartbrainintro.di.SBIntroFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators

class SBIntroNavigatorImpl(private val router: SBFeatureRouter) : SBAppNavigators.Intro {

    override fun navigateToIntro() {
        SBIntroFeatureComponentImpl().featureInject()
        router.navigateTo(
            screen = SBIntroFeatureScreen.Main,
            navigationType = SBNavigationType.REPLACE_AND_POP,
            animation = SBAnimation.fadeIn()
        )
    }
}