package com.example.smartbrainguessmovies.data.repository

import com.example.smartbrainguessmovies.data.datasource.SBGuessMoviesDataSource
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesRequestMapper
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesResponseMapper
import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain
import com.example.smartbrainguessmovies.domain.repository.SBGuessMoviesRepository

class SBGuessMoviesRepositoryImpl(
    private val dataSource: SBGuessMoviesDataSource,
    private val requestMapper: SBGuessMoviesRequestMapper,
    private val responseMapper: SBGuessMoviesResponseMapper,
) : SBGuessMoviesRepository {

    override suspend fun insertGuessMovies(model: SBGuessMoviesDomain) {
        dataSource.insertGuessMovies(requestMapper.mapModel(model))
    }

    override suspend fun getAllGuessMovies(): List<SBGuessMoviesDomain> {
        return responseMapper.mapToList(dataSource.getGuessMovies())
    }
}