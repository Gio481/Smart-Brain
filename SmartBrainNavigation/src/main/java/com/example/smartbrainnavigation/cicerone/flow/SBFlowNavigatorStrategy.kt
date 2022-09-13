package com.example.smartbrainnavigation.cicerone.flow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.SBAnimation
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorStrategy

class SBFlowNavigatorStrategy : SBNavigatorStrategy<SBFlowScreen> {
    override fun setUpTransaction(
        screen: SBFlowScreen,
        fragment: Fragment,
        transaction: FragmentTransaction,
        backStackSize: Int,
    ) {
        if (backStackSize == 0) {
            transaction.setCustomAnimations(
                (screen.animation.reEnterTransition as SBAnimation.Resources).resource,
                (screen.animation.reEnterTransition as SBAnimation.Resources).resource,
                (screen.animation.reEnterTransition as SBAnimation.Resources).resource,
                (screen.animation.reEnterTransition as SBAnimation.Resources).resource,
            )
        } else {
            transaction.setCustomAnimations(
                (screen.animation.enterTransition as SBAnimation.Resources).resource,
                (screen.animation.exitTransition as SBAnimation.Resources).resource,
                (screen.animation.reEnterTransition as SBAnimation.Resources).resource,
                (screen.animation.reExitTransition as SBAnimation.Resources).resource,
            )
        }
    }
}