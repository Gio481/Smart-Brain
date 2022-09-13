package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.View
import com.example.smartbraincomponents.R

abstract class SBBaseFlowFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>() {

    open fun showBackButton() = true
    open fun showActionView() = true
    open fun isArrowVisible() = true
    open fun actionView(): Int = R.layout.sb_default_action_view_layout
    open fun defaultActionViewText() = R.string.next
    open fun defaultActionViewArrowVisibility() = true
    open fun defaultAction() {}
    open fun handleBackPress() {}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (parentFragment as SBBaseFeatureFragment<*>).setUpActions(this)
    }
}