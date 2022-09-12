package com.example.smartbrainguesscharacters.feature.guess_movie.screens

import androidx.fragment.app.Fragment
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.ui.SBGuessMoviesIntroFragment
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.ui.SBGuessMoviesListFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBGuessMoviesFlowScreens : SBFlowScreen() {
    object Intro : SBGuessMoviesFlowScreens() {
        override fun getFragment(): Fragment = SBGuessMoviesIntroFragment()
    }

    object MoviesList : SBGuessMoviesFlowScreens() {
        override fun getFragment(): Fragment = SBGuessMoviesListFragment()
    }
}