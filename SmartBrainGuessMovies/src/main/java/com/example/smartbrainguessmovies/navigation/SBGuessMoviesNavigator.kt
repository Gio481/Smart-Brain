package com.example.smartbrainguessmovies.navigation

import com.example.smartbrainnavigation.cicerone.SBNavigationType

interface SBGuessMoviesNavigator {
    fun navigateToStartGame(navigationType: SBNavigationType = SBNavigationType.REPLACE)
    fun navigateToDetails(navigationType: SBNavigationType = SBNavigationType.REPLACE)
    fun navigateToPlayGame(navigationType: SBNavigationType = SBNavigationType.REPLACE)
}