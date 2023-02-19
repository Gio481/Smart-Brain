package com.example.smartbrainnavigation.cicerone.base

import androidx.fragment.app.Fragment

interface SBBaseScreen {
    val screenKey: String get() = this::class.java.name
    fun getFragment(): Fragment
}