package com.example.smartbrainguesscharacters.presentation.guess_movie.child_my_smartbrain_view

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesChildViewBinding
import com.example.smartbrainguesscharacters.navigation.SBGuessCharacterNavigator
import com.example.smartbrainguesscharacters.navigation.SBGuessCharacterNavigatorImpl
import org.koin.java.KoinJavaComponent.get

class SBGuessMoviesChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding = SbGuessMoviesChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val navigator = get<SBGuessCharacterNavigator>(SBGuessCharacterNavigatorImpl::class.java)

    init {
        binding.root.setOnClickListener {
            navigator.navigateToGuessMovies()
        }
    }
}