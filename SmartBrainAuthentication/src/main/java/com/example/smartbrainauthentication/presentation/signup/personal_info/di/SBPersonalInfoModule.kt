package com.example.smartbrainauthentication.presentation.signup.personal_info.di

import com.example.smartbrainauthentication.presentation.signup.personal_info.ui.SBPersonalInfoFragment
import com.example.smartbrainauthentication.presentation.signup.personal_info.vm.SBPersonalInfoViewModel
import com.example.smartbraincomponents.koin.SBPerScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBPersonalInfoModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBPersonalInfoFragment>() {
    override fun onScreenModule() = module {
        viewModel {
            SBPersonalInfoViewModel(service = get(featureQualifier))
        }
    }
}