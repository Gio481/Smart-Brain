package com.example.smartbrainauthentication.presentation.signin.login.di

import com.example.smartbrainauthentication.presentation.signin.login.ui.SBSignInFragment
import com.example.smartbrainauthentication.presentation.signin.login.vm.SBSignInViewModel
import com.example.smartbraincomponents.koin.SBPerScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBLogInModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBSignInFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBSignInViewModel(homeNavigator = get(), service = get(featureQualifier))
        }
    }
}