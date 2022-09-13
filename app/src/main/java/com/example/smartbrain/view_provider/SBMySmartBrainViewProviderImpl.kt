package com.example.smartbrain.view_provider

import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainfindsimilarpieces.my_smart_brain.SBFindSimilarPiecesMySmartBrainContainer
import com.example.smartbrainguesscharacters.my_smart_brain.SBGuessCharacterMySmartBrainContainer
import com.example.smartbrainguesscharacters.presentation.guess_character.child_my_smartbrain_view.SBGuessCharacterChildView
import com.example.smartbrainguesscharacters.presentation.guess_character_quote.child_my_smartbrain_view.SBGuessCharacterQuoteChildView
import com.example.smartbrainguesscharacters.presentation.guess_movie.child_my_smartbrain_view.SBGuessMoviesChildView

class SBMySmartBrainViewProviderImpl(private val context: Context) : SBMySmartBrainViewProvider {

    override fun getViews(): List<SBMySmartBrainBaseView> {
        return mutableListOf<SBMySmartBrainBaseView>().apply {
            add(
                SBGuessCharacterMySmartBrainContainer(context = context,
                    mutableListOf(
                        SBGuessMoviesChildView(context),
                        SBGuessCharacterChildView(context),
                        SBGuessCharacterQuoteChildView(context)
                    )
                )
            )
            add(
                SBFindSimilarPiecesMySmartBrainContainer(context = context)
            )
        }.toList()
    }
}