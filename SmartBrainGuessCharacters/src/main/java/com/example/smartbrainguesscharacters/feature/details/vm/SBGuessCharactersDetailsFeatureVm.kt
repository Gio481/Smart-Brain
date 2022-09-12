package com.example.smartbrainguesscharacters.feature.details.vm

import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguesscharacters.feature.details.screens.SBDetailsFlowScreens
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService

class SBGuessCharactersDetailsFeatureVm(service: SBFlowRouterService) : SBBaseViewModel(service) {

    fun setStartFragment(){
        changeScreen(screen = SBDetailsFlowScreens.Main)
    }
}