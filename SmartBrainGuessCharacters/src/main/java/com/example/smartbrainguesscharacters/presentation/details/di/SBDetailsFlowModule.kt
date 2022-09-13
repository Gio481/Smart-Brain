package com.example.smartbrainguesscharacters.presentation.details.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguesscharacters.presentation.details.ui.SBDetailsFlowFragment
import com.example.smartbrainguesscharacters.presentation.details.vm.SBDetailsFlowVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBDetailsFlowModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBDetailsFlowFragment>() {

    override fun onScreenModule() = module {
        viewModel { SBDetailsFlowVm(services = get(featureQualifier)) }
    }
}