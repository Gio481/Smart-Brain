package com.example.smartbrain.view_provider

import android.view.ViewGroup
import com.example.smartbraincomponents.view_provider.SBViewProvider

class SBMySmartBrainViewProviderImpl:SBMySmartBrainViewProvider {

    override fun getViews(view: ViewGroup): List<SBViewProvider> {
        val items = mutableListOf<SBViewProvider>()

        return items.toList()
    }
}