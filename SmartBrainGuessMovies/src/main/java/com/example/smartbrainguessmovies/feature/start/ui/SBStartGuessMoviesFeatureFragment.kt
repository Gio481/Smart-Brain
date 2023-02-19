package com.example.smartbrainguessmovies.feature.start.ui

import android.os.Bundle
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainguessmovies.R
import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainguessmovies.feature.start.vm.SBStartGuessMoviesFeatureVm

class SBStartGuessMoviesFeatureFragment : SBBaseFeatureFragment<SBStartGuessMoviesFeatureVm>() {

    override fun getViewModelClass() = SBStartGuessMoviesFeatureVm::class

    override fun getTitleResId(): Int = R.string.guess_movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm?.setStartFragment()
    }

    override fun onDestroyComponents() {
        SBStartGuessMoviesFeatureComponentImpl().featureDestroy()
    }
}