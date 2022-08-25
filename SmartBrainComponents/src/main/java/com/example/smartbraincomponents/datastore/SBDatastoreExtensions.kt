package com.example.smartbraincomponents.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal suspend fun DataStore<Preferences>.save(key: String, value: Boolean) {
    this.edit { preference ->
        preference[booleanPreferencesKey(key)] = value
    }
}

internal fun DataStore<Preferences>.get(key: String): Flow<Boolean?> {
    val preference = this.data.map { preference ->
        preference[booleanPreferencesKey(key)]
    }
    return preference
}

internal suspend fun DataStore<Preferences>.removeEach(list: List<String>) {
    this.edit { preference ->
        list.forEach { key ->
            preference.remove(booleanPreferencesKey(key))
        }
    }
}