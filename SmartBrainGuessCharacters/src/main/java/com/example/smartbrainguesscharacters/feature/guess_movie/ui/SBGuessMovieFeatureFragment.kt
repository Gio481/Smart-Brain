package com.example.smartbrainguesscharacters.feature.guess_movie.ui

import android.os.Bundle
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.feature.guess_movie.di.SBGuessMoviesFeatureComponentImpl
import com.example.smartbrainguesscharacters.feature.guess_movie.vm.SBGuessMoviesFeatureVm
import kotlin.reflect.KClass

class SBGuessMovieFeatureFragment : SBBaseFeatureFragment<SBGuessMoviesFeatureVm>() {

    override fun getViewModelClass(): KClass<SBGuessMoviesFeatureVm> = SBGuessMoviesFeatureVm::class

    override fun getTitleResId(): Int = R.string.guess_movies

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm?.setStartFragment()
    }

    override fun onDestroyComponents() {
        SBGuessMoviesFeatureComponentImpl().featureDestroy()
    }

}