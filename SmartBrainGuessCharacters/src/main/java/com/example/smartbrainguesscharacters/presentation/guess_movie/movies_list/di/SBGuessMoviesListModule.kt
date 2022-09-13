package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.di

import com.example.smartbraincomponents.koin.SBPerScreen
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.ui.SBGuessMoviesListFragment
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.vm.SBGuessMoviesListVm
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessMoviesListModule(override val featureQualifier: StringQualifier) :
    SBPerScreen<SBGuessMoviesListFragment>() {

    override fun onScreenModule() = module {
        viewModel {
            SBGuessMoviesListVm(
                services = get(featureQualifier),
                navigator = get()
            )
        }
    }
}