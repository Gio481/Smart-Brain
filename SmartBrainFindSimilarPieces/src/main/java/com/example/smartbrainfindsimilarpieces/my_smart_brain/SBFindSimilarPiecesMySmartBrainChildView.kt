package com.example.smartbrainfindsimilarpieces.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainfindsimilarpieces.databinding.SbFindSimilarMySmartBrainChildViewBinding

class SBFindSimilarPiecesMySmartBrainChildView(context: Context) :
    SBMySmartBrainBaseChildView(context) {

    private val binding =
        SbFindSimilarMySmartBrainChildViewBinding.inflate(LayoutInflater.from(context), this, true)
}