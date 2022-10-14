package com.example.smartbrainguessmovies.feature.details.di

import com.example.smartbraincomponents.extension.getFeatureQualifier
import com.example.smartbrainguessmovies.feature.details.ui.SBGuessMoviesDetailsFeatureFragment
import com.example.smartbrainguessmovies.presentation.details.di.SBGuessMoviesDetailsModule

class SBGuessMoviesDetailsFeatureComponentImpl:SBGuessMoviesDetailsFeatureComponent {
    override fun detailsModule() = SBGuessMoviesDetailsModule(featureQualifier())
    override fun featureModule() = SBGuessMoviesDetailsFeatureModule(featureQualifier())
    override fun featureQualifier() = SBGuessMoviesDetailsFeatureFragment::class.java.getFeatureQualifier()
    override fun featureDestroy() = featureModule().destroy()
}