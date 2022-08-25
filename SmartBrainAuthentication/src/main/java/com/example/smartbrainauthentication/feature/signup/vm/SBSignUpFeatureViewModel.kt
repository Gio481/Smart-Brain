package com.example.smartbrainauthentication.feature.signup.vm

import com.example.smartbrainauthentication.feature.signup.screen.SBSignUpFlowScreens
import com.example.smartbraincomponents.base.SBBaseViewModel

class SBSignUpFeatureViewModel:SBBaseViewModel() {

    fun setStartFragment(){
        changeScreen(screen = SBSignUpFlowScreens.Main)
    }
}