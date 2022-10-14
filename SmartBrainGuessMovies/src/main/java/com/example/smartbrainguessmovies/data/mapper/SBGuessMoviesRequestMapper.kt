package com.example.smartbrainguessmovies.data.mapper

import com.example.smartbraincomponents.components.mapper.SBMapper
import com.example.smartbraindatabase.entity.SBGuessMoviesEntity
import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain

class SBGuessMoviesRequestMapper:SBMapper<SBGuessMoviesDomain, SBGuessMoviesEntity> {

    override fun mapModel(model: SBGuessMoviesDomain): SBGuessMoviesEntity {
            return SBGuessMoviesEntity(
                level = model.level,
                genre = model.genre
            )
    }
}