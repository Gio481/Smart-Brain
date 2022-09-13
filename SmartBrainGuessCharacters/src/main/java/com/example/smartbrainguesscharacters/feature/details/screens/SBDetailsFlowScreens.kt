package com.example.smartbrainguesscharacters.feature.details.screens

import androidx.fragment.app.Fragment
import com.example.smartbrainguesscharacters.presentation.details.ui.SBDetailsFlowFragment
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen

sealed class SBDetailsFlowScreens : SBFlowScreen() {

    object Main : SBDetailsFlowScreens() {
        override fun getFragment(): Fragment = SBDetailsFlowFragment()
    }
}