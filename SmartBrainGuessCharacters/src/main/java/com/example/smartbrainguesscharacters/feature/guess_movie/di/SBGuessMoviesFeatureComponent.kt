package com.example.smartbrainguesscharacters.feature.guess_movie.di

import com.example.smartbraincomponents.koin.SBBaseFeatureComponent
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.di.SBGuessMoviesIntroModule
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.di.SBGuessMoviesListModule

interface SBGuessMoviesFeatureComponent : SBBaseFeatureComponent {
    fun introModule(): SBGuessMoviesIntroModule
    fun moviesListModule(): SBGuessMoviesListModule
}