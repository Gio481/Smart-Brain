package com.example.smartbrainguesscharacters.feature.guess_movie.di

import com.example.smartbraincomponents.extension.getFeatureQualifier
import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainguesscharacters.feature.guess_movie.ui.SBGuessMovieFeatureFragment
import com.example.smartbrainguesscharacters.presentation.guess_movie.intro.di.SBGuessMoviesIntroModule
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.di.SBGuessMoviesListModule

class SBGuessMoviesFeatureComponentImpl : SBGuessMoviesFeatureComponent {

    override fun introModule() = SBGuessMoviesIntroModule(featureQualifier())
    override fun moviesListModule() = SBGuessMoviesListModule(featureQualifier())
    override fun featureModule(): SBPerFeature = SBGuessMoviesFeatureModule(featureQualifier())
    override fun featureDestroy() = featureModule().destroy()
    override fun featureQualifier() = SBGuessMovieFeatureFragment::class.java.getFeatureQualifier()
}