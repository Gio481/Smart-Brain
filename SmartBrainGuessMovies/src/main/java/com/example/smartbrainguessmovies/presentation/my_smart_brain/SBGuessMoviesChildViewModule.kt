package com.example.smartbrainguessmovies.presentation.my_smart_brain

import com.example.smartbrainguessmovies.data.datasource.SBGuessMoviesDataSource
import com.example.smartbrainguessmovies.data.datasource.SBGuessMoviesDatasourceImpl
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesRequestMapper
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesResponseMapper
import com.example.smartbrainguessmovies.data.repository.SBGuessMoviesRepositoryImpl
import com.example.smartbrainguessmovies.domain.repository.SBGuessMoviesRepository
import com.example.smartbrainguessmovies.domain.usecase.SBGuessMoviesResponseUseCaseImpl
import org.koin.dsl.module

val guessMoviesMySmartBrainModule = module {
    single<SBGuessMoviesDataSource> { SBGuessMoviesDatasourceImpl(get()) }
    single { SBGuessMoviesRequestMapper() }
    single { SBGuessMoviesResponseMapper() }
    single<SBGuessMoviesRepository> { SBGuessMoviesRepositoryImpl(get(), get(), get()) }
    single { SBGuessMoviesResponseUseCaseImpl(get()) }
}