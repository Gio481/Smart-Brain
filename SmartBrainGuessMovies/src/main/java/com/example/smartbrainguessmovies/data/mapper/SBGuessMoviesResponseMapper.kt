package com.example.smartbrainguessmovies.data.mapper

import com.example.smartbraincomponents.components.mapper.SBMapper
import com.example.smartbraindatabase.entity.SBGuessMoviesEntity
import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain

class SBGuessMoviesResponseMapper:SBMapper<SBGuessMoviesEntity, SBGuessMoviesDomain> {
    override fun mapModel(model: SBGuessMoviesEntity): SBGuessMoviesDomain {
        return SBGuessMoviesDomain(level = model.level, genre = model.genre)
    }
}