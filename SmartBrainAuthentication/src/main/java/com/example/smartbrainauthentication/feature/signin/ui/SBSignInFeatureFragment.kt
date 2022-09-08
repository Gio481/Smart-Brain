package com.example.smartbrainauthentication.feature.signin.ui

import android.os.Bundle
import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.feature.signin.screen.SBSignInFlowScreen
import com.example.smartbrainauthentication.feature.signin.vm.SBSignInFeatureViewModel
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import kotlin.reflect.KClass

class SBSignInFeatureFragment : SBBaseFeatureFragment<SBSignInFeatureViewModel>() {

    override fun isChildFragmentFlowPart(): Boolean = false

    override fun getTitleResId(): Int = R.string.sign_in

    override fun getViewModelClass(): KClass<SBSignInFeatureViewModel> =
        SBSignInFeatureViewModel::class


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm?.setStartFragment()
    }

    override fun onDestroyComponents() {
        SBSignInFeatureComponentImpl().featureDestroy()
    }

}