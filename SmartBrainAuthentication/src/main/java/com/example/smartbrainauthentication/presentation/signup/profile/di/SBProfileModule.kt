package com.example.smartbrainauthentication.presentation.signup.profile.di

import com.example.smartbrainauthentication.presentation.signup.profile.ui.SBProfileFragment
import com.example.smartbrainauthentication.presentation.signup.profile.vm.SBProfileViewModel
import com.example.smartbraincomponents.koin.SBPerScreen
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBProfileModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBProfileFragment>() {

    override fun onScreenModule() = module {
        viewModel{
            SBProfileViewModel(service = get(featureQualifier), homeNavigator = get())
        }
    }
}