package com.example.smartbrainguesscharacters.presentation.guess_movie.intro.ui

import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesIntroLayoutBinding
import com.example.smartbrainguesscharacters.feature.guess_movie.di.SBGuessMoviesFeatureComponentImpl
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.vm.SBGuessMoviesIntroVm
import kotlin.reflect.KClass

class SBGuessMoviesIntroFragment : SBBaseFlowFragment<SBGuessMoviesIntroVm>() {

    override fun getViewModelClass(): KClass<SBGuessMoviesIntroVm> = SBGuessMoviesIntroVm::class

    override val screenLayout: Int = R.layout.sb_guess_movies_intro_layout

    override fun showBackButton(): Boolean = false

    override fun defaultAction() {
        vm?.next()
    }

    private val binding by viewBinding(SbGuessMoviesIntroLayoutBinding::bind)

    override fun initializeInjector() {
        SBGuessMoviesFeatureComponentImpl().introModule().inject(this)
    }

    override fun onBindViewModel(vm: SBGuessMoviesIntroVm) {
    }
}