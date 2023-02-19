package com.example.smartbrainhome.navigation

import com.example.smartbrainhome.di.SBHomeFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators

class SBHomeNavigatorImpl(private val router: SBFeatureRouter) : SBAppNavigators.Home {

    override fun navigateToHome() {
        SBHomeFeatureComponentImpl().featureInject()
        router.navigateTo(screen = SBHomeFeatureScreen.Main, navigationType = SBNavigationType.REPLACE_AND_CLEAR)
    }
}