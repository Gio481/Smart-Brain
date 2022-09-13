package com.example.smartbraindatabase.dao.user

import androidx.room.*
import com.example.smartbraindatabase.entity.SBUserEntity

@Dao
interface SBUserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: SBUserEntity)

    @Update
    suspend fun updateUser(user: SBUserEntity)

    @Delete
    suspend fun deleteUser(user: SBUserEntity)
}