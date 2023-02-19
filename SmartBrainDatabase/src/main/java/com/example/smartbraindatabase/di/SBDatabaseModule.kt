package com.example.smartbraindatabase.di

import com.example.smartbraindatabase.db.provideGuessMoviesDao
import com.example.smartbraindatabase.db.provideSBDatabase
import org.koin.dsl.module


val databaseModule = module {
    single { provideSBDatabase(context = get()) }
    single { provideGuessMoviesDao(db = get()) }
}