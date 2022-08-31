package com.example.smartbrainauthentication.presentation.signin.di

import com.example.smartbrainauthentication.presentation.signin.ui.SBSignInFragment
import com.example.smartbrainauthentication.presentation.signin.vm.SBSignInViewModel
import com.example.smartbraincomponents.koin.SBPerScreen
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.definition._createDefinition
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.withOptions
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBSignInModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBSignInFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBSignInViewModel(homeNavigator = get())
        }
    }
}