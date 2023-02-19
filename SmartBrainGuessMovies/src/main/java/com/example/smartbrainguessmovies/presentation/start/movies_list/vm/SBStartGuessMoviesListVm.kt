package com.example.smartbrainguessmovies.presentation.start.movies_list.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguessmovies.feature.start.screens.SBStartGuessMoviesFlowScreens
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBStartGuessMoviesListVm(service: SBFlowRouterService) : SBBaseViewModel(service) {

    fun next(){
        changeScreen(SBStartGuessMoviesFlowScreens.Completion)
    }
}