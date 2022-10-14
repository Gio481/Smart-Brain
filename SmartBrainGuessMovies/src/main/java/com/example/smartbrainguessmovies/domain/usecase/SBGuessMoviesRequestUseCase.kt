package com.example.smartbrainguessmovies.domain.usecase

import com.example.smartbraincomponents.components.usecase.SBBaseUseCase
import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain
import com.example.smartbrainguessmovies.domain.repository.SBGuessMoviesRepository

class SBGuessMoviesRequestUseCase(
    private val repository: SBGuessMoviesRepository,
) :SBBaseUseCase<Unit, SBGuessMoviesDomain>(){

    override suspend fun operation(params: SBGuessMoviesDomain?) {
        repository.insertGuessMovies(params!!)
    }
}