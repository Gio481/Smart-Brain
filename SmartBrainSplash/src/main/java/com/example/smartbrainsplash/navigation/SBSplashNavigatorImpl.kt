package com.example.smartbrainsplash.navigation

import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainsplash.di.SBSplashFeatureComponentImpl

class SBSplashNavigatorImpl(private val router: SBFeatureRouter): SBAppNavigators.Splash {
    override fun navigateToSplash() {
        SBSplashFeatureComponentImpl().featureInject()
        router.navigateTo(
            SBSplashScreens.Main,
            navigationType = SBNavigationType.REPLACE,
            animation = SBAnimation.Fade()
        )
    }
}