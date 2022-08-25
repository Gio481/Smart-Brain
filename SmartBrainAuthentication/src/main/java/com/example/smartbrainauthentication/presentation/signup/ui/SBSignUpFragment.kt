package com.example.smartbrainauthentication.presentation.signup.ui

import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainauthentication.presentation.signup.vm.SBSignUpViewModel
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import kotlin.reflect.KClass

class SBSignUpFragment : SBBaseFlowFragment<SBSignUpViewModel>() {

    override fun getViewModelClass(): KClass<SBSignUpViewModel> = SBSignUpViewModel::class

    override val screenLayout: Int = R.layout.sb_authentication_signup_fragment

    override fun initializeInjector() {
        SBSignUpFeatureComponentImpl().signUpModule().inject(this)
    }
}