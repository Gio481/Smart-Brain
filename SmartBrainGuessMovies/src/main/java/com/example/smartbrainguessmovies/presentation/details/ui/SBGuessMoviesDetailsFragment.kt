package com.example.smartbrainguessmovies.presentation.details.ui

import com.example.smartbrainguesscharacterscommon.presentation.details.ui.SBGuessCharactersBaseDetailsFragment
import com.example.smartbrainguessmovies.feature.details.di.SBGuessMoviesDetailsFeatureComponentImpl
import com.example.smartbrainguessmovies.presentation.details.vm.SBGuessMoviesDetailsVm

class SBGuessMoviesDetailsFragment: SBGuessCharactersBaseDetailsFragment<SBGuessMoviesDetailsVm>() {

    override fun getViewModelClass() = SBGuessMoviesDetailsVm::class

    override fun initializeInjector() {
        SBGuessMoviesDetailsFeatureComponentImpl().detailsModule().inject(this)
    }
}