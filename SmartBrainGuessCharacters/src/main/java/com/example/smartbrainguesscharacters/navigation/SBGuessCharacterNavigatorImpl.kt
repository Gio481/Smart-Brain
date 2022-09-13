package com.example.smartbrainguesscharacters.navigation

import com.example.smartbrainguesscharacters.feature.details.di.SBDetailsFeatureComponentImpl
import com.example.smartbrainguesscharacters.feature.guess_movie.di.SBGuessMoviesFeatureComponentImpl
import com.example.smartbrainnavigation.cicerone.SBNavigationType
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter

class SBGuessCharacterNavigatorImpl(private val router: SBFeatureRouter) : SBGuessCharacterNavigator {

    override fun navigateToGuessCharacter() {

    }

    override fun navigateToGuessMovies() {
        SBGuessMoviesFeatureComponentImpl().featureInject()
        router.navigateTo(screen = SBGuessCharacterFeatureScreens.GuessMovie)
    }

    override fun navigateToGuessCharacterQuote() {
    }

    override fun navigateToDetails() {
        SBDetailsFeatureComponentImpl().featureInject()
        router.navigateTo(screen = SBGuessCharacterFeatureScreens.Details, navigationType = SBNavigationType.REPLACE_AND_POP)
    }
}