package com.example.smartbraincomponents.view_provider

import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView

interface SBMySmartBrainViewProvider {
    fun getViews(): List<SBMySmartBrainBaseView>
}