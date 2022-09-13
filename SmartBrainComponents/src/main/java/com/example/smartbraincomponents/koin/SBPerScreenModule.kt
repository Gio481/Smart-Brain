package com.example.smartbraincomponents.koin

import androidx.lifecycle.LifecycleOwner
import org.koin.core.qualifier.StringQualifier

internal interface SBPerScreenModule<L:LifecycleOwner> {
    val featureQualifier:StringQualifier

    fun inject(lifecycleOwner: L)

    fun destroy(lifecycleOwner: LifecycleOwner)
}