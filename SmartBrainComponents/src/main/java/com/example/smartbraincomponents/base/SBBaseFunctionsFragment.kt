package com.example.smartbraincomponents.base

import com.example.smartbraincomponents.R

abstract class SBBaseFunctionsFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>() {
    open fun showBackButton():Boolean {
        return true
    }
    open fun isArrowVisible():Boolean {
        return true
    }
    open fun actionView(): Int = R.layout.sb_default_action_view_layout
    open fun defaultActionViewText(): Int {
        return R.string.next
    }
    open fun defaultActionViewArrowVisibility() = true
    var defaultActionListener: (() -> Unit)? = null
    open fun showActionView() = true
    open fun giorgi(){}
}