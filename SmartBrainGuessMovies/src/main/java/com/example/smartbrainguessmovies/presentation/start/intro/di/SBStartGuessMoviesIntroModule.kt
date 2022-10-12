package com.example.smartbrainguessmovies.presentation.start.intro.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguessmovies.presentation.start.intro.ui.SBStartGuessMoviesIntroFragment
import com.example.smartbrainguessmovies.presentation.start.intro.vm.SBStartGuessMoviesIntroVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBStartGuessMoviesIntroModule(override val featureQualifier: StringQualifier) : SBPerScreen<SBStartGuessMoviesIntroFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBStartGuessMoviesIntroVm(
                services = get(featureQualifier))
        }
    }
}