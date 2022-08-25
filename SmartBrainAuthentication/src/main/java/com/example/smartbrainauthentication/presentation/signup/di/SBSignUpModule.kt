package com.example.smartbrainauthentication.presentation.signup.di

import com.example.smartbrainauthentication.presentation.signup.ui.SBSignUpFragment
import com.example.smartbrainauthentication.presentation.signup.vm.SBSignUpViewModel
import com.example.smartbraincomponents.koin.SBPerScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBSignUpModule(override val featureQualifier: StringQualifier) :SBPerScreen<SBSignUpFragment>() {
    override fun onScreenModule() = module {
        viewModel {
            SBSignUpViewModel()
        }
    }
}