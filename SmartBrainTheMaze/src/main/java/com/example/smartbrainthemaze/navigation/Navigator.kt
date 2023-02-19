package com.example.smartbrainthemaze.navigation

import androidx.fragment.app.Fragment
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainthemaze.feature.play.di.FeatureComponentImpl
import com.example.smartbrainthemaze.feature.play.ui.FeatureUI

interface Navigator {
    fun navigateToMaze()
}

class NavigatorImpl(private val router: SBFeatureRouter) : Navigator {
    override fun navigateToMaze() {
        FeatureComponentImpl().featureInject()
        router.navigateTo(Screen.Main)
    }

}

sealed class Screen : SBFeatureScreen() {
    object Main : Screen() {
        override fun getFragment(): Fragment {
            return FeatureUI()
        }
    }
}
