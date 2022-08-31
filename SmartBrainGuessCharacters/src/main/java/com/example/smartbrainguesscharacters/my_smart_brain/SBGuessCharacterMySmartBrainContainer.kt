package com.example.smartbrainguesscharacters.my_smart_brain

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log.d
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainViewContainer
import com.example.smartbrainguesscharacters.R

@SuppressLint("ViewConstructor")
class SBGuessCharacterMySmartBrainContainer(context: Context):SBMySmartBrainViewContainer(context) {
    override fun mySmartBrainTitle(): Int {
       return R.string.guess_character
    }

    init {
        d("guram", "ee")
    }

    override val view: SBMySmartBrainBaseChildView = SBGuessCharacterMySmartBrainChildView(context)
}