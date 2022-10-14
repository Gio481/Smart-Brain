package com.example.smartbrainauthentication.navigation

import com.example.smartbrainnavigation.cicerone.SBNavigationType

interface SBAuthenticationNavigator {
    fun navigateToSignIn(
        navigationType: SBNavigationType = SBNavigationType.REPLACE,
    )

    fun navigateToSignUp(
        navigationType: SBNavigationType = SBNavigationType.REPLACE,
    )
}