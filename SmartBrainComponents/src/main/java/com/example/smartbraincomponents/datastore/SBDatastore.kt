package com.example.smartbraincomponents.datastore

import kotlinx.coroutines.flow.Flow

interface SBDatastore {

    suspend fun saveSBIntroValue(key: String, value: Boolean)
    fun getSBIntroValue(key: String): Flow<Boolean?>

    suspend fun saveIfUserLoggedInValue(key: String, value: Boolean)
    fun getIfUseLoggedInValue(key: String): Flow<Boolean?>

    suspend fun saveSBOtpNeedsValue(key: String, value: Boolean)
    fun getSBOtpNeedsValue(key: String): Flow<Boolean?>

    suspend fun removeValuesAfterLogOut()

    /**
     * add each game onBoarding value
     */
}