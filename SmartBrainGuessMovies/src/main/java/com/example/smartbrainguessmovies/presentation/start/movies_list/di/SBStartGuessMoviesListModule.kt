package com.example.smartbrainguessmovies.presentation.start.movies_list.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguessmovies.presentation.start.movies_list.ui.SBStartGuessMoviesListFragment
import com.example.smartbrainguessmovies.presentation.start.movies_list.vm.SBStartGuessMoviesListVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBStartGuessMoviesListModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBStartGuessMoviesListFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBStartGuessMoviesListVm(service = get(featureQualifier))
        }
    }
}