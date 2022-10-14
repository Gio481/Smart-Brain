package com.example.smartbrainguessmovies.presentation.details.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguessmovies.presentation.details.ui.SBGuessMoviesDetailsFragment
import com.example.smartbrainguessmovies.presentation.details.vm.SBGuessMoviesDetailsVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessMoviesDetailsModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBGuessMoviesDetailsFragment>() {

    override fun onScreenModule() = module {
        viewModel{
            SBGuessMoviesDetailsVm(service = get(featureQualifier))
        }
    }
}