package com.example.smartbraincomponents.base

import androidx.lifecycle.ViewModel
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

open class SBBaseViewModel() : ViewModel(), KoinComponent {
    val router: SBFlowRouter by inject()
}