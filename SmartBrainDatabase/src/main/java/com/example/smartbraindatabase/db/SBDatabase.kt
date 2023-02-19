package com.example.smartbraindatabase.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smartbraindatabase.dao.user.SBGuessMoviesDao
import com.example.smartbraindatabase.entity.SBGuessMoviesEntity

@Database(entities = [SBGuessMoviesEntity::class], version = 1)
abstract class SBDatabase : RoomDatabase() {
    abstract fun guessMoviesDao(): SBGuessMoviesDao
}