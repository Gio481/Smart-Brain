package com.example.smartbrainguessmovies.navigation

import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBGuessMoviesNavigatorImpl(private val featureRouter: SBFeatureRouter) : SBGuessMoviesNavigator {

    override fun navigateToStartGame(navigationType: SBNavigationType) {
        SBStartGuessMoviesFeatureComponentImpl().featureInject()
        featureRouter.navigateTo(SBGuessMoviesFeatureScreens.Start, navigationType = navigationType)
    }

    override fun navigateToDetails(navigationType: SBNavigationType) {
        TODO("Not yet implemented")
    }

    override fun navigateToPlayGame(navigationType: SBNavigationType) {
        TODO("Not yet implemented")
    }
}