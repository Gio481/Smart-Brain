package com.example.smartbrainintro.navigation

import com.example.smartbrainintro.di.SBIntroFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBIntroNavigatorImpl(private val router: SBFeatureRouter) : SBIntroNavigator {

    override fun navigateToIntro() {
        SBIntroFeatureComponentImpl().featureInject()
        router.navigateTo(screen = SBIntroFeatureScreen.Main, navigationType = SBNavigationType.REPLACE, animation = SBAnimation.None)
    }
}