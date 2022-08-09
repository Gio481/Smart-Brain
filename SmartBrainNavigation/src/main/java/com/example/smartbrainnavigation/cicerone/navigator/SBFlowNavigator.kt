package com.example.smartbrainnavigation.cicerone.navigator

import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainnavigation.cicerone.SBNavigationStrategy
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

class SBFlowNavigator(
    fragment: SBBaseFeatureFragment<*>,
    private val router: SBFlowRouter?,
    strategy: SBNavigationStrategy<SBFlowScreen>,
) : SBAppNavigator<SBFlowScreen>(
    fragment.requireActivity(),
    R.id.fragmentBaseContainer,
    strategy
) {
    override fun activityBack() {
        router?.back()
    }
}