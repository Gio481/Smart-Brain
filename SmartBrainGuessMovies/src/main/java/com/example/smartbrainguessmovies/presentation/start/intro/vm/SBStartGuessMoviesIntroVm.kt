package com.example.smartbrainguessmovies.presentation.start.intro.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguessmovies.feature.start.screens.SBStartGuessMoviesFlowScreens
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBStartGuessMoviesIntroVm(services: SBFlowRouterService) : SBBaseViewModel(services) {

    fun next() {
        changeScreen(screen = SBStartGuessMoviesFlowScreens.MoviesList)
    }
}