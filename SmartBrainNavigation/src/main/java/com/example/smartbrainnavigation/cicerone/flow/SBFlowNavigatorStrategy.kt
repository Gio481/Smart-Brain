package com.example.smartbrainnavigation.cicerone.flow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.SBNavigationStrategy

class SBFlowNavigatorStrategy : SBNavigationStrategy<SBFlowScreen> {

    override fun setUpAnimation(
        screen: SBFlowScreen,
        transaction: FragmentTransaction,
        fragment: Fragment,
        backStackSize: Int,
    ) {
        with(SBAnimation) {
            if (backStackSize == 0) {
                fragment.exitTransition = fadeOut().transition
            } else {
                fragment.exitTransition = fadeIn().transition
                fragment.enterTransition = fadeIn().transition
                fragment.reenterTransition = fadeIn().transition
                fragment.returnTransition = fadeIn().transition
            }
        }
    }
}