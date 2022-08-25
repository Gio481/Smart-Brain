package com.example.smartbrainsplash.feature.vm

import androidx.lifecycle.viewModelScope
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigator
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainintro.navigation.SBIntroNavigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SBSplashFeatureViewModel(
    private val introNavigator:SBIntroNavigator,
) : SBBaseViewModel() {


    init {
        navigateToSmartBrainIntro()
    }

    private fun navigateToSmartBrainIntro() {
        viewModelScope.launch {
            delay(3000)
            introNavigator.navigateToIntro()
        }
    }
}