package com.example.smartbrain.view_provider

import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainfindsimilarpieces.my_smart_brain.SBFindSimilarPiecesMySmartBrainContainer
import com.example.smartbrainguesscharacters.presentation.my_smart_brain.SBGuessCharactersChildView
import com.example.smartbrainguesscharacterscommon.presentation.components.my_smart_brain.SBGuessCharacterMySmartBrainContainer
import com.example.smartbrainguessmovies.presentation.my_smart_brain.SBGuessMoviesChildView

class SBMySmartBrainViewProviderImpl(private val context: Context) : SBMySmartBrainViewProvider {

    override fun getViews(): List<SBMySmartBrainBaseView> {
        return mutableListOf<SBMySmartBrainBaseView>().apply {
            add(
                SBGuessCharacterMySmartBrainContainer(context = context, listOf(
                    SBGuessMoviesChildView(context = context),
                    SBGuessCharactersChildView(context = context)
                ))
            )
            add(
                SBFindSimilarPiecesMySmartBrainContainer(context = context)
            )
        }.toList()
    }
}