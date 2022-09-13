package com.example.smartbrainguesscharacters.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainguesscharacters.feature.details.ui.SBGuessCharactersDetailsFeatureFragment
import com.example.smartbrainguesscharacters.feature.guess_character.ui.SBGuessCharacterFeatureFragment
import com.example.smartbrainguesscharacters.feature.guess_character_quote.ui.SBGuessCharacterQuoteFeatureFragment
import com.example.smartbrainguesscharacters.feature.guess_movie.ui.SBGuessMovieFeatureFragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen

sealed class SBGuessCharacterFeatureScreens : SBFeatureScreen() {

    object GuessMovie : SBGuessCharacterFeatureScreens() {
        override fun getFragment(): Fragment = SBGuessMovieFeatureFragment()
    }

    object GuessCharacter : SBGuessCharacterFeatureScreens() {
        override fun getFragment(): Fragment = SBGuessCharacterFeatureFragment()
    }

    object GuessCharacterQuote : SBGuessCharacterFeatureScreens() {
        override fun getFragment(): Fragment = SBGuessCharacterQuoteFeatureFragment()
    }

    object Details : SBGuessCharacterFeatureScreens() {
        override fun getFragment(): Fragment = SBGuessCharactersDetailsFeatureFragment()
    }
}
