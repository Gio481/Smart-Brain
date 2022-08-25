package com.example.smartbrainsplash.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainsplash.feature.ui.SBSplashFeatureFragment

sealed class SBSplashScreens : SBFeatureScreen() {
    object Main : SBSplashScreens() {
        override fun getFragment(): Fragment = SBSplashFeatureFragment()
    }
}