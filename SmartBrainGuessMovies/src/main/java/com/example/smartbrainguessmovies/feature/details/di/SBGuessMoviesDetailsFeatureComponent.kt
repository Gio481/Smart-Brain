package com.example.smartbrainguessmovies.feature.details.di

import com.example.smartbraincomponents.koin.SBBaseFeatureComponent
import com.example.smartbrainguessmovies.presentation.details.di.SBGuessMoviesDetailsModule

interface SBGuessMoviesDetailsFeatureComponent : SBBaseFeatureComponent{
    fun detailsModule():SBGuessMoviesDetailsModule
}