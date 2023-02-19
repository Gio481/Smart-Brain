package com.example.smartbrainguessmovies.navigation

import com.example.smartbrainguessmovies.feature.details.di.SBGuessMoviesDetailsFeatureComponentImpl
import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators

class SBGuessMoviesNavigatorImpl(private val router: SBFeatureRouter) : SBAppNavigators.GuessCharacters {

    override fun navigateToStartGame(navigationType: SBNavigationType) {
        SBStartGuessMoviesFeatureComponentImpl().featureInject()
        router.navigateTo(SBGuessMoviesFeatureScreens.Start, navigationType = navigationType)
    }

    override fun navigateToDetails(navigationType: SBNavigationType) {
        SBGuessMoviesDetailsFeatureComponentImpl().featureInject()
        router.navigateTo(SBGuessMoviesFeatureScreens.Details, navigationType = navigationType)
    }

    override fun navigateToPlayGame(navigationType: SBNavigationType) {
        TODO("Not yet implemented")
    }
}