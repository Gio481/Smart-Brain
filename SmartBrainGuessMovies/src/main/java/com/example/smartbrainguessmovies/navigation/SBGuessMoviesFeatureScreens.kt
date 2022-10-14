package com.example.smartbrainguessmovies.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainguessmovies.feature.details.ui.SBGuessMoviesDetailsFeatureFragment
import com.example.smartbrainguessmovies.feature.start.ui.SBStartGuessMoviesFeatureFragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen

sealed class SBGuessMoviesFeatureScreens : SBFeatureScreen() {

    object Start : SBGuessMoviesFeatureScreens() {
        override fun getFragment() = SBStartGuessMoviesFeatureFragment()
    }

    object Details: SBGuessMoviesFeatureScreens() {
        override fun getFragment() = SBGuessMoviesDetailsFeatureFragment()
    }

    object Play: SBGuessMoviesFeatureScreens() {
        override fun getFragment(): Fragment {
            TODO("Not yet implemented")
        }
    }

}