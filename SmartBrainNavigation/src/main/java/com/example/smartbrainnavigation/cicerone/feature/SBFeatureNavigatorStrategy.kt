package com.example.smartbrainnavigation.cicerone.feature

import android.transition.Transition
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.SBNavigationStrategy

class SBFeatureNavigatorStrategy : SBNavigationStrategy<SBFeatureScreen> {
    override fun setUpAnimation(
        screen: SBFeatureScreen,
        transaction: FragmentTransaction,
        fragment: Fragment,
        backStackSize: Int,
    ) {
        screen.animation.let { fragment.enterTransition = it.transition }
        setTransitionListener(fragment)
    }

    private fun setTransitionListener(fragment: Fragment) {
        val transitionListener = (fragment as? SBFragmentTransitionListener)
            ?: throw RuntimeException("$fragment can't be casted to SBFragmentTransitionListener")
        (fragment.enterTransition as Transition).addListener(object :
            Transition.TransitionListener {
            override fun onTransitionStart(p0: Transition?) {
                transitionListener.onEnterTransitionStart()
            }

            override fun onTransitionEnd(p0: Transition?) {
                (transitionListener as? SBFragmentTransitionListener)?.onEnterTransitionEnd()
                (fragment.enterTransition as? Transition)?.removeListener(this)
            }

            override fun onTransitionCancel(p0: Transition?) {}
            override fun onTransitionPause(p0: Transition?) {}
            override fun onTransitionResume(p0: Transition?) {}
        })
    }
}