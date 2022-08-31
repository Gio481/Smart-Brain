package com.example.smartbrain.view_provider

import android.content.Context
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainguesscharacters.my_smart_brain.SBGuessCharacterMySmartBrainContainer
import com.example.smartbrainhome.presentation.custom_view.SBHomeCustomScrollView

class SBMySmartBrainViewProviderImpl(private val context: Context) : SBMySmartBrainViewProvider {

    override fun getViews(): List<SBMySmartBrainBaseView> {
        val items = mutableListOf<SBMySmartBrainBaseView>()
        items.add(SBGuessCharacterMySmartBrainContainer(context = context))
        return items.toList()
    }
}