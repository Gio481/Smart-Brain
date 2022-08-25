package com.example.smartbrainintro.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainintro.feature.ui.SBIntroFeatureFragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen

sealed class SBIntroFeatureScreen : SBFeatureScreen() {
    object Main : SBIntroFeatureScreen() {
        override fun getFragment(): Fragment = SBIntroFeatureFragment()
    }
}