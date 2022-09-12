package com.example.smartbraincomponents.util

import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorStrategy

class SBFlowNavigator(
    fragment: SBBaseFeatureFragment<*>,
    private val router: SBFlowRouter?,
    strategy: SBNavigatorStrategy<SBFlowScreen>,
) : SBAppNavigator<SBFlowScreen>(
    fragment.requireActivity(),
    R.id.fragmentBaseContainer,
    strategy,
    fragment.childFragmentManager,
) {
    override fun activityBack() {
        router?.back()
    }
}