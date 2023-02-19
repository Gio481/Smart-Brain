package com.example.smartbraindatabase.db

import android.content.Context
import androidx.room.Room

fun provideSBDatabase(context: Context):SBDatabase{
    return Room.databaseBuilder(context, SBDatabase::class.java, "smart_brain.db").build()
}

fun provideGuessMoviesDao(db:SBDatabase) = db.guessMoviesDao()