package com.example.smartbrainguesscharacters.presentation.guess_character_quote.child_my_smartbrain_view

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguesscharacters.databinding.SbGuessCharacterQuoteChildViewBinding

class SBGuessCharacterQuoteChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding =
        SbGuessCharacterQuoteChildViewBinding.inflate(LayoutInflater.from(context), this, true)
}