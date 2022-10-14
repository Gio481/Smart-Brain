package com.example.smartbrainguessmovies.feature.details.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguessmovies.feature.details.screens.SBGuessMoviesDetailsFlowScreen
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBGuessMoviesDetailsFeatureVm(service: SBFlowRouterService):SBBaseViewModel(service) {

    fun setStartFragment(){
        changeScreen(SBGuessMoviesDetailsFlowScreen.Main)
    }
}