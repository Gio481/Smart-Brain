package com.example.smartbrainauthentication.presentation.signup.personal_info.ui

import android.util.Log
import android.util.Log.d
import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.databinding.SbAuthenticationPersonalInfoFragmentBinding
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainauthentication.presentation.signup.personal_info.vm.SBPersonalInfoViewModel
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import kotlin.reflect.KClass

class SBPersonalInfoFragment : SBBaseFlowFragment<SBPersonalInfoViewModel>() {

    override fun getViewModelClass(): KClass<SBPersonalInfoViewModel> = SBPersonalInfoViewModel::class

    override val screenLayout: Int = R.layout.sb_authentication_personal_info_fragment

    override fun giorgi() {
        vm?.next()
    }

    private val binding by viewBinding(SbAuthenticationPersonalInfoFragmentBinding::bind)

    override fun initializeInjector() {
        SBSignUpFeatureComponentImpl().personalInfoModule().inject(this)
    }

    override fun onBindViewModel(vm: SBPersonalInfoViewModel) {

    }

    override fun isChildFragmentFlowPart(): Boolean {
        return true
    }

}