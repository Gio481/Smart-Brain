package com.example.smartbraindatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "smart_brain_user")
data class SBUserEntity(
    @PrimaryKey
    val id: Long = 0,
    val email: String,
    val name: String,
    val password: String,
)