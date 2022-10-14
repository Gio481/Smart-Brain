package com.example.smartbrainguessmovies.domain.usecase

import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain
import com.example.smartbrainguessmovies.domain.repository.SBGuessMoviesRepository

class SBGuessMoviesResponseUseCaseImpl(private val repository: SBGuessMoviesRepository) {

    suspend fun getAllGuessMovies(): List<SBGuessMoviesDomain> {
        return repository.getAllGuessMovies()
    }
}