package com.example.smartbrainguessmovies.presentation.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguessmovies.databinding.SbGuessMoviesChildViewBinding
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigator
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigatorImpl
import org.koin.java.KoinJavaComponent.get

class SBGuessMoviesChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding = SbGuessMoviesChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val navigator = get<SBGuessMoviesNavigator>(SBGuessMoviesNavigatorImpl::class.java)

    init {
        binding.root.setOnClickListener {
            navigator.navigateToStartGame()
        }
    }
}