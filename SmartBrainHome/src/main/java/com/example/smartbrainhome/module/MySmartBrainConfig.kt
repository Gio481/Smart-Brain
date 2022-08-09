package com.example.smartbrainhome.module

import com.example.smartbraincomponents.view_provider.SBViewProvider

object MySmartBrainConfig {

    private var mySmartBrainItemProvider: (() -> List<SBViewProvider>)? = null

    fun setMySmartBrainItemProvider(provider: () -> List<SBViewProvider>) {
        this.mySmartBrainItemProvider = provider
    }

    val mySmartBrainItemProviders = mySmartBrainItemProvider?.invoke()
}