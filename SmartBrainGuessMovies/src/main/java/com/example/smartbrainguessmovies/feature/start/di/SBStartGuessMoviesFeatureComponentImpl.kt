package com.example.smartbrainguessmovies.feature.start.di

import com.example.smartbraincomponents.extension.getFeatureQualifier
import com.example.smartbrainguessmovies.feature.start.ui.SBStartGuessMoviesFeatureFragment
import com.example.smartbrainguessmovies.presentation.start.intro.di.SBStartGuessMoviesIntroModule
import com.example.smartbrainguessmovies.presentation.start.movies_list.di.SBStartGuessMoviesListModule

class SBStartGuessMoviesFeatureComponentImpl : SBStartGuessMoviesFeatureComponent {
    override fun introModule() = SBStartGuessMoviesIntroModule(featureQualifier())
    override fun moviesListModule() = SBStartGuessMoviesListModule(featureQualifier())
    override fun featureModule() = SBStartGuessMoviesFeatureModule(featureQualifier())
    override fun featureQualifier() = SBStartGuessMoviesFeatureFragment::class.java.getFeatureQualifier()
    override fun featureDestroy() = featureModule().destroy()
}