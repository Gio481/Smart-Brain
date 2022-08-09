package com.example.smartbrainnavigation.cicerone.feature

interface SBFragmentTransitionListener {
    fun onEnterTransitionStart() {}
    fun onEnterTransitionEnd() {}
    fun onReturnTransitionStart() {}
    fun onReturnTransitionEnd() {}
}