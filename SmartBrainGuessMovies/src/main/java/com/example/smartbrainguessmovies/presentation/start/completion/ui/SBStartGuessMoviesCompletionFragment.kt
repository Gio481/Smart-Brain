package com.example.smartbrainguessmovies.presentation.start.completion.ui

import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbrainguessmovies.R
import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainguessmovies.presentation.start.completion.vm.SBStartGuessMoviesCompletionVm

class SBStartGuessMoviesCompletionFragment : SBBaseFlowFragment<SBStartGuessMoviesCompletionVm>() {

    override fun getViewModelClass() = SBStartGuessMoviesCompletionVm::class

    override val screenLayout: Int = R.layout.sb_start_guess_movies_completion_fragment

    override fun defaultActionViewText() = R.string.completion_default_view_text

    override fun initializeInjector() {
        SBStartGuessMoviesFeatureComponentImpl().completionModule().inject(this)
    }

    override fun defaultAction() {
        nonAnimation()
        vm?.navigateToDetails()
    }

}