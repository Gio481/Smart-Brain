package com.example.smartbrain.di

import com.example.smartbraincomponents.datastore.datastoreModule

val sbInitialModules = listOf(
    sbNavigatorModule,
    viewProvidesModule,
    datastoreModule,
)