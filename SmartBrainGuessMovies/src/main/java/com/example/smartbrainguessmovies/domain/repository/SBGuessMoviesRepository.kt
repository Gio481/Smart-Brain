package com.example.smartbrainguessmovies.domain.repository

import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain

interface SBGuessMoviesRepository {
    suspend fun insertGuessMovies(model:SBGuessMoviesDomain)
    suspend fun getAllGuessMovies():List<SBGuessMoviesDomain>
}