package com.example.smartbrainguessmovies.data.datasource

import com.example.smartbraindatabase.entity.SBGuessMoviesEntity

interface SBGuessMoviesDataSource {
    suspend fun insertGuessMovies(guessMovies: SBGuessMoviesEntity)
    suspend fun getGuessMovies(): List<SBGuessMoviesEntity>
}