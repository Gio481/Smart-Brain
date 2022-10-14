package com.example.smartbrainguessmovies.feature.details.screens

import com.example.smartbrainguessmovies.presentation.details.ui.SBGuessMoviesDetailsFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBGuessMoviesDetailsFlowScreen : SBFlowScreen() {

    object Main : SBGuessMoviesDetailsFlowScreen() {
        override fun getFragment() = SBGuessMoviesDetailsFragment()
    }
}