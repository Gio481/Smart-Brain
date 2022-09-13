package com.example.smartbraincomponents.extension

import org.koin.core.qualifier.StringQualifier

fun <T> Class<T>.getFeatureQualifier() = StringQualifier(this.toString())
