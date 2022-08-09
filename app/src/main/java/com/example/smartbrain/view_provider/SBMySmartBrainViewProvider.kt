package com.example.smartbrain.view_provider

import android.view.ViewGroup
import com.example.smartbraincomponents.view_provider.SBViewProvider

interface SBMySmartBrainViewProvider {
    fun getViews(view: ViewGroup): List<SBViewProvider>
}