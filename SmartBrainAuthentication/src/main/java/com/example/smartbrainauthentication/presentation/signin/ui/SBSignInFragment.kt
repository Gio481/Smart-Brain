package com.example.smartbrainauthentication.presentation.signin.ui

import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.databinding.SbAuthenticationSigninFragmentBinding
import com.example.smartbrainauthentication.feature.signin.di.SBSignInFeatureComponentImpl
import com.example.smartbrainauthentication.presentation.signin.vm.SBSignInViewModel
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.util.viewBinding
import kotlin.reflect.KClass

class SBSignInFragment : SBBaseFlowFragment<SBSignInViewModel>() {

    override fun getViewModelClass(): KClass<SBSignInViewModel> = SBSignInViewModel::class

    override val screenLayout: Int = R.layout.sb_authentication_signin_fragment

    private val binding by viewBinding(SbAuthenticationSigninFragmentBinding::bind)

    override fun initializeInjector() {
        SBSignInFeatureComponentImpl().signInModule().inject(this)
    }

    override fun onBindViewModel(vm: SBSignInViewModel) {
        binding.giorgi.text = "ioe"
    }
}