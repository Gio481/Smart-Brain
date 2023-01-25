package com.example.smartbrainthemaze.presentation.my_smart_brain

import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainViewContainer
import com.example.smartbrainthemaze.R

class SBTheMazeMySmartBrainContainer(context: Context):SBMySmartBrainViewContainer(context) {
    override fun mySmartBrainTitle() = R.string.the_maze_title

    override val view = SBTheMazeMySmartBrainChildView(context)
}