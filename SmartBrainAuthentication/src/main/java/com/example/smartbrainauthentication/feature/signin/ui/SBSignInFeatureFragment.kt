package com.example.smartbrainauthentication.feature.signin.ui

import android.os.Bundle
import android.util.Log.d
import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.feature.signin.screen.SBSignInFlowScreen
import com.example.smartbrainauthentication.feature.signin.vm.SBSignInFeatureViewModel
import com.example.smartbrainauthentication.presentation.signin.ui.SBSignInFragment
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import kotlin.reflect.KClass

class SBSignInFeatureFragment : SBBaseFeatureFragment<SBSignInFeatureViewModel>() {

    override fun getViewModelClass(): KClass<SBSignInFeatureViewModel> =
        SBSignInFeatureViewModel::class

    override fun getTitleResId(): Int = R.string.sign_in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startFragment(SBSignInFlowScreen.Main)
//        vm?.setStartFragment()
    }

    override fun onDestroyComponents() {
        SBSignInFeatureComponentImpl().featureDestroy()
    }
}