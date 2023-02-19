package com.example.smartbrainnavigation.cicerone.navigator

import com.example.smartbrainnavigation.cicerone.SBNavigationType

sealed interface SBAppNavigators {
    interface Splash : SBAppNavigators {
        fun navigateToSplash()
    }

    interface Intro : SBAppNavigators {
        fun navigateToIntro()
    }

    interface Authentication {
        fun navigateToSignIn(navigationType: SBNavigationType = SBNavigationType.ADD)
        fun navigateToSignUp(navigationType: SBNavigationType = SBNavigationType.ADD)
    }

    interface Home {
        fun navigateToHome()
    }

    interface GuessCharacters {
        fun navigateToStartGame(navigationType: SBNavigationType = SBNavigationType.ADD)
        fun navigateToDetails(navigationType: SBNavigationType = SBNavigationType.ADD)
        fun navigateToPlayGame(navigationType: SBNavigationType = SBNavigationType.ADD)
    }

}