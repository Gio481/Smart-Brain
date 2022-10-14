package com.example.smartbrainguessmovies.feature.details.ui

import android.os.Bundle
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainguessmovies.R
import com.example.smartbrainguessmovies.feature.details.di.SBGuessMoviesDetailsFeatureComponentImpl
import com.example.smartbrainguessmovies.feature.details.vm.SBGuessMoviesDetailsFeatureVm

class SBGuessMoviesDetailsFeatureFragment : SBBaseFeatureFragment<SBGuessMoviesDetailsFeatureVm>() {

    override fun getTitleResId() = R.string.guess_movies_details

    override fun getViewModelClass() = SBGuessMoviesDetailsFeatureVm::class

    override fun onDestroyComponents() {
        SBGuessMoviesDetailsFeatureComponentImpl().featureDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm?.setStartFragment()
    }
}