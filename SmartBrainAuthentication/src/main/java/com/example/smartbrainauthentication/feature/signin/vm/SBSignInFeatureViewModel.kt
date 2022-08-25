package com.example.smartbrainauthentication.feature.signin.vm

import android.util.Log
import com.example.smartbrainauthentication.feature.signin.screen.SBSignInFlowScreen
import com.example.smartbraincomponents.base.SBBaseViewModel

class SBSignInFeatureViewModel:SBBaseViewModel() {
    fun setStartFragment(){
        changeScreen(screen = SBSignInFlowScreen.Main)
    }
}