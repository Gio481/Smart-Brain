package com.example.smartbrainfindsimilarpieces.my_smart_brain

import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainViewContainer
import com.example.smartbrainfindsimilarpieces.R

class SBFindSimilarPiecesMySmartBrainContainer(context: Context):SBMySmartBrainViewContainer(context) {
    override fun mySmartBrainTitle(): Int {
        return R.string.find_similar_pieces
    }

    override val view: SBMySmartBrainBaseChildView = SBFindSimilarPiecesMySmartBrainChildView(context)

    init {
        successState()
    }
}