package com.example.smartbrainnavigation.cicerone.feature

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorStrategy

class SBFeatureNavigatorStrategy : SBNavigatorStrategy<SBFeatureScreen> {

    override fun setUpTransaction(
        screen: SBFeatureScreen,
        fragment: Fragment,
        transaction: FragmentTransaction,
        backStackSize: Int,
    ) {
        screen.animation.let {
            fragment.enterTransition = it.transition
        }
    }
}