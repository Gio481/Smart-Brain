package com.example.smartbrainnavigation.cicerone.base

import androidx.fragment.app.Fragment
import com.example.smartbrainnavigation.cicerone.screen.SBScreen

interface SBBaseScreen : SBScreen {
    fun getFragment(): Fragment
}