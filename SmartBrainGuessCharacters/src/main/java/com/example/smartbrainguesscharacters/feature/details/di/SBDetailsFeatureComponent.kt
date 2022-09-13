package com.example.smartbrainguesscharacters.feature.details.di

import com.example.smartbraincomponents.koin.SBBaseFeatureComponent
import com.example.smartbrainguesscharacters.presentation.details.di.SBDetailsFlowModule

interface SBDetailsFeatureComponent : SBBaseFeatureComponent {
    fun detailsFlowModule():SBDetailsFlowModule
}