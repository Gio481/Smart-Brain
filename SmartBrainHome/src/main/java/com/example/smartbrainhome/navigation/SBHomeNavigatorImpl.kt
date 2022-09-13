package com.example.smartbrainhome.navigation

import com.example.smartbrainhome.di.SBHomeFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBHomeNavigatorImpl(private val router: SBFeatureRouter) : SBHomeNavigator {

    override fun navigateToHome() {
        SBHomeFeatureComponentImpl().featureInject()
        router.navigateTo(screen = SBHomeFeatureScreen.Main, navigationType = SBNavigationType.REPLACE)
    }
}