package com.example.smartbrainguessmovies.feature.details.di

import com.example.smartbraincomponents.koin.SBPerFeature
import com.example.smartbrainguessmovies.data.datasource.SBGuessMoviesDataSource
import com.example.smartbrainguessmovies.data.datasource.SBGuessMoviesDatasourceImpl
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesRequestMapper
import com.example.smartbrainguessmovies.data.mapper.SBGuessMoviesResponseMapper
import com.example.smartbrainguessmovies.data.repository.SBGuessMoviesRepositoryImpl
import com.example.smartbrainguessmovies.domain.repository.SBGuessMoviesRepository
import com.example.smartbrainguessmovies.domain.usecase.SBGuessMoviesResponseUseCaseImpl
import com.example.smartbrainguessmovies.feature.details.vm.SBGuessMoviesDetailsFeatureVm
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.module

class SBGuessMoviesDetailsFeatureModule(override val featureQualifier: StringQualifier) : SBPerFeature() {

    override fun onFeatureModule() = module {
        viewModel {
            SBGuessMoviesDetailsFeatureVm(service = get(featureQualifier))
        }
        injectFlowNavigatorModule(featureQualifier)

        single<SBGuessMoviesDataSource>(featureQualifier) { SBGuessMoviesDatasourceImpl(get()) }
        single(featureQualifier) { SBGuessMoviesRequestMapper() }
        single(featureQualifier) { SBGuessMoviesResponseMapper() }
        single<SBGuessMoviesRepository>(featureQualifier) { SBGuessMoviesRepositoryImpl(get(), get(), get()) }
        single(featureQualifier) { SBGuessMoviesResponseUseCaseImpl(get()) }
    }
}