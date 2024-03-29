package com.example.smartbraincomponents.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(
    name = "smart_brain_datastore"
)

private fun provideSBDatastore(context: Context): DataStore<Preferences> {
    return context.datastore
}

val datastoreModule = module {
    single { provideSBDatastore(androidContext()) }
    single<SBDatastore> { SBDatastoreImpl(dataStore = get()) }
}