package com.example.smartbrainguesscharacters.presentation.guess_movie.intro.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguesscharacters.feature.guess_movie.screens.SBGuessMoviesFlowScreens
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBGuessMoviesIntroVm(services: SBFlowRouterService) : SBBaseViewModel(services) {

    fun next() {
        changeScreen(screen = SBGuessMoviesFlowScreens.MoviesList)
    }
}