package com.example.smartbrainguesscharacters.presentation.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguesscharacters.databinding.SbGuessCharacterChildViewBinding

class SBGuessCharactersChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding = SbGuessCharacterChildViewBinding.inflate(LayoutInflater.from(context), this, true)
}