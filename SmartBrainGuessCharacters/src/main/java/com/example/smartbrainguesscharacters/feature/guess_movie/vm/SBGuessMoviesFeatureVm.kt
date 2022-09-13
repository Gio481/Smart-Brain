package com.example.smartbrainguesscharacters.feature.guess_movie.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguesscharacters.feature.guess_movie.screens.SBGuessMoviesFlowScreens
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBGuessMoviesFeatureVm(service: SBFlowRouterService) : SBBaseViewModel(service) {

    fun setStartFragment(){
        changeScreen(screen = SBGuessMoviesFlowScreens.Intro)
    }
}