package com.example.smartbrainguessmovies.data.datasource

import com.example.smartbraindatabase.dao.user.SBGuessMoviesDao
import com.example.smartbraindatabase.entity.SBGuessMoviesEntity

class SBGuessMoviesDatasourceImpl(
    private val dao: SBGuessMoviesDao,
) : SBGuessMoviesDataSource {

    override suspend fun insertGuessMovies(guessMovies: SBGuessMoviesEntity) {
        dao.insertGuessMovie(guessMovies)
    }

    override suspend fun getGuessMovies(): List<SBGuessMoviesEntity> {
        return dao.getAllGuessMovies()
    }
}