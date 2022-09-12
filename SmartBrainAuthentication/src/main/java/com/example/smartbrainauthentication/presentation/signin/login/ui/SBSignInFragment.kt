package com.example.smartbrainauthentication.presentation.signin.login.ui

import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.databinding.SbAuthenticationSigninFragmentBinding
import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.presentation.signin.login.vm.SBSignInViewModel
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import kotlin.reflect.KClass

class SBSignInFragment : SBBaseFlowFragment<SBSignInViewModel>() {

    override fun getViewModelClass(): KClass<SBSignInViewModel> = SBSignInViewModel::class

    override val screenLayout: Int = R.layout.sb_authentication_signin_fragment

    override fun defaultActionViewText(): Int = R.string.sign_in

    override fun showBackButton(): Boolean = false

    override fun defaultAction() {
        vm?.navigateToHome()
    }

    private val binding by viewBinding(SbAuthenticationSigninFragmentBinding::bind)

    override fun initializeInjector() {
        SBSignInFeatureComponentImpl().loginModule().inject(this)
    }

    override fun onBindViewModel(vm: SBSignInViewModel) {
    }

}