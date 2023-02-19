package com.example.smartbrain.di

import com.example.smartbraincomponents.datastore.datastoreModule
import com.example.smartbraindatabase.di.databaseModule
import com.example.smartbrainguessmovies.presentation.my_smart_brain.guessMoviesMySmartBrainModule

val sbInitialModules = listOf(
    sbNavigatorModule,
    viewProvidesModule,
    datastoreModule,
    databaseModule,
    guessMoviesMySmartBrainModule,
    dispatcherProviderModule,
    fireBaseModule
)