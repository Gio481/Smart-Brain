package com.example.smartbrainguessmovies.presentation.start.intro.ui

import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguessmovies.R
import com.example.smartbrainguessmovies.databinding.SbStartGuessMoviesIntroFragmentBinding
import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainguessmovies.presentation.start.intro.vm.SBStartGuessMoviesIntroVm

class SBStartGuessMoviesIntroFragment : SBBaseFlowFragment<SBStartGuessMoviesIntroVm>() {

    override fun getViewModelClass() = SBStartGuessMoviesIntroVm::class

    override val screenLayout: Int = R.layout.sb_start_guess_movies_intro_fragment

    override fun showBackButton(): Boolean = false

    override fun defaultAction() {
        vm?.next()
    }

    private val binding by viewBinding(SbStartGuessMoviesIntroFragmentBinding::bind)

    override fun initializeInjector() {
        SBStartGuessMoviesFeatureComponentImpl().introModule().inject(this)
    }

    override fun onBindViewModel(vm: SBStartGuessMoviesIntroVm) {
        super.onBindViewModel(vm)
    }
}