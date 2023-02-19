package com.example.smartbrainhome.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainhome.feature.ui.SBHomeFeatureFragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen

sealed class SBHomeFeatureScreen : SBFeatureScreen() {
    object Main : SBHomeFeatureScreen() {
        override fun getFragment(): Fragment = SBHomeFeatureFragment()
    }
}