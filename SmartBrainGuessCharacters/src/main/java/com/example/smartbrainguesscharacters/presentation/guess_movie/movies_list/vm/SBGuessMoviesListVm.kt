package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguesscharacters.navigation.SBGuessCharacterNavigator
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBGuessMoviesListVm(
    services:SBFlowRouterService,
    private val navigator:SBGuessCharacterNavigator
) : SBBaseViewModel(services) {


    fun navigateToDetails(){
        navigator.navigateToDetails()
    }
}