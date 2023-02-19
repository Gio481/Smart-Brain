package com.example.smartbrainguessmovies.presentation.start.completion.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguessmovies.presentation.start.completion.ui.SBStartGuessMoviesCompletionFragment
import com.example.smartbrainguessmovies.presentation.start.completion.vm.SBStartGuessMoviesCompletionVm
import com.example.smartbrainnavigation.cicerone.constants.GUESS_MOVIES
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBStartGuessMoviesCompletionModule(override val featureQualifier: StringQualifier) :
    SBPerScreen<SBStartGuessMoviesCompletionFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBStartGuessMoviesCompletionVm(
                service = get(featureQualifier),
                navigator = get(GUESS_MOVIES),
                useCase = get(featureQualifier)
            )
        }
    }
}