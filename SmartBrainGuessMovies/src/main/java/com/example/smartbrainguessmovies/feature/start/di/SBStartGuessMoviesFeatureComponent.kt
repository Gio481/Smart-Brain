package com.example.smartbrainguessmovies.feature.start.di

import com.example.smartbraincomponents.koin.SBBaseFeatureComponent
import com.example.smartbrainguessmovies.presentation.start.intro.di.SBStartGuessMoviesIntroModule
import com.example.smartbrainguessmovies.presentation.start.movies_list.di.SBStartGuessMoviesListModule

interface SBStartGuessMoviesFeatureComponent : SBBaseFeatureComponent {
    fun introModule(): SBStartGuessMoviesIntroModule
    fun moviesListModule(): SBStartGuessMoviesListModule
}