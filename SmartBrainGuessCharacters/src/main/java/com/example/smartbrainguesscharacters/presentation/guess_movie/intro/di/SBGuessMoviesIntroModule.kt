package com.example.smartbrainguesscharacters.presentation.guess_movie.intro.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.ui.SBGuessMoviesIntroFragment
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.vm.SBGuessMoviesIntroVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessMoviesIntroModule(override val featureQualifier: StringQualifier) :
    SBPerScreen<SBGuessMoviesIntroFragment>() {
    override fun onScreenModule() = module {
        viewModel { SBGuessMoviesIntroVm(services = get(featureQualifier)) }
    }
}