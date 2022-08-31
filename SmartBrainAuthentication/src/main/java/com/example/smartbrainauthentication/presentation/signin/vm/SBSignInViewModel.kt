package com.example.smartbrainauthentication.presentation.signin.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainhome.navigation.SBHomeNavigator

class SBSignInViewModel(private val homeNavigator:SBHomeNavigator) : SBBaseViewModel() {
    fun navigateToHome(){
        homeNavigator.navigateToHome()
    }
}