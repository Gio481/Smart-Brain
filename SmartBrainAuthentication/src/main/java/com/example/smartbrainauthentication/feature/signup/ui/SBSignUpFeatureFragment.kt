package com.example.smartbrainauthentication.feature.signup.ui

import android.os.Bundle
import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainauthentication.feature.signup.vm.SBSignUpFeatureViewModel
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import kotlin.reflect.KClass

class SBSignUpFeatureFragment : SBBaseFeatureFragment<SBSignUpFeatureViewModel>() {

    override fun getViewModelClass(): KClass<SBSignUpFeatureViewModel> =
        SBSignUpFeatureViewModel::class

    override fun getTitleResId(): Int = R.string.sign_up

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm?.setStartFragment()
    }

    override fun onDestroyComponents() {
        SBSignUpFeatureComponentImpl().featureDestroy()
    }
}