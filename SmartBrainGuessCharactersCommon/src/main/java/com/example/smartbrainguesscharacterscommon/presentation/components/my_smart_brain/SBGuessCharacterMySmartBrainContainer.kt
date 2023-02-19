package com.example.smartbrainguesscharacterscommon.presentation.components.my_smart_brain

import android.annotation.SuppressLint
import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainViewContainer
import com.example.smartbrainguesscharacterscommon.R

@SuppressLint("ViewConstructor")
class SBGuessCharacterMySmartBrainContainer(
    context: Context,
    childViewList: List<SBMySmartBrainBaseChildView>,
) : SBMySmartBrainViewContainer(context) {

    override fun mySmartBrainTitle(): Int {
        return R.string.guess_character_container
    }


    override val view: SBMySmartBrainBaseChildView =
        SBGuessCharacterMySmartBrainChildView(context, childViewList)


    init {
        successState()
    }
}