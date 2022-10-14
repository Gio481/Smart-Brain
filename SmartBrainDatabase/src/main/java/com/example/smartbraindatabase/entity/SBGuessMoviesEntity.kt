package com.example.smartbraindatabase.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guess_movies_table")
data class SBGuessMoviesEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 0,
    val level: Int,
    val genre: String,
)