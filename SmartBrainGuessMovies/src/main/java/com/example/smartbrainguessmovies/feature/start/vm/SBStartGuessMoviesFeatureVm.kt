package com.example.smartbrainguessmovies.feature.start.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguessmovies.feature.start.screens.SBStartGuessMoviesFlowScreens
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBStartGuessMoviesFeatureVm(service: SBFlowRouterService):SBBaseViewModel(service) {

    fun setStartFragment(){
        changeScreen(SBStartGuessMoviesFlowScreens.Intro)
    }
}