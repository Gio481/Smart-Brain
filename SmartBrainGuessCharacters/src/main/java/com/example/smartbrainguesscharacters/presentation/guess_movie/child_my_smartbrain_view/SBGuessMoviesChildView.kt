package com.example.smartbrainguesscharacters.presentation.guess_movie.child_my_smartbrain_view

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesChildViewBinding

class SBGuessMoviesChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding = SbGuessMoviesChildViewBinding.inflate(LayoutInflater.from(context), this, true)
}