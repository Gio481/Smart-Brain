package com.example.smartbrainguessmovies.feature.start.screens

import com.example.smartbrainguessmovies.presentation.start.completion.ui.SBStartGuessMoviesCompletionFragment
import com.example.smartbrainguessmovies.presentation.start.intro.ui.SBStartGuessMoviesIntroFragment
import com.example.smartbrainguessmovies.presentation.start.movies_list.ui.SBStartGuessMoviesListFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBStartGuessMoviesFlowScreens : SBFlowScreen() {

    object Intro : SBStartGuessMoviesFlowScreens() {
        override fun getFragment() = SBStartGuessMoviesIntroFragment()
    }

    object MoviesList : SBStartGuessMoviesFlowScreens() {
        override fun getFragment() = SBStartGuessMoviesListFragment()
    }

    object Completion : SBStartGuessMoviesFlowScreens() {
        override fun getFragment() = SBStartGuessMoviesCompletionFragment()
    }
}