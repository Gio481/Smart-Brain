package com.example.smartbraincomponents.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.example.smartbraincomponents.datastore.SBDatastoreKeys.OTP_NEEDS
import com.example.smartbraincomponents.datastore.SBDatastoreKeys.SB_INTRO_KEY
import com.example.smartbraincomponents.datastore.SBDatastoreKeys.USER_IS_LOGGED
import com.example.smartbraincomponents.extension.get
import com.example.smartbraincomponents.extension.removeEach
import com.example.smartbraincomponents.extension.save
import kotlinx.coroutines.flow.Flow

class SBDatastoreImpl(private val dataStore: DataStore<Preferences>) : SBDatastore {

    private val list = listOf(SB_INTRO_KEY, USER_IS_LOGGED, OTP_NEEDS)

    override suspend fun saveSBIntroValue(key: String, value: Boolean) = dataStore.save(key, value)
    override fun getSBIntroValue(key: String): Flow<Boolean?> = dataStore.get(key)

    override suspend fun saveIfUserLoggedInValue(key: String, value: Boolean) = dataStore.save(key, value)
    override fun getIfUseLoggedInValue(key: String): Flow<Boolean?> = dataStore.get(key)

    override suspend fun saveSBOtpNeedsValue(key: String, value: Boolean) = dataStore.save(key, value)
    override fun getSBOtpNeedsValue(key: String): Flow<Boolean?> = dataStore.get(key)

    override suspend fun removeValuesAfterLogOut() = dataStore.removeEach(list)
}
