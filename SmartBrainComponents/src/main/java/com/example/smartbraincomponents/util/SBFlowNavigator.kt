package com.example.smartbraincomponents.util

import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigator

class SBFlowNavigator(
    fragment: SBBaseFeatureFragment<*>,
    private val router: SBFlowRouter?,
) : SBAppNavigator<SBFlowScreen>(
    fragment.requireActivity(),
    R.id.fragmentBaseContainer,
) {
    override fun activityBack() {
        router?.back()
    }
}