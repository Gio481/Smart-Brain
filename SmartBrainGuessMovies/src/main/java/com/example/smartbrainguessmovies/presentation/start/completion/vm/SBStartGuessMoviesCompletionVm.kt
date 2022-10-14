package com.example.smartbrainguessmovies.presentation.start.completion.vm

import androidx.lifecycle.viewModelScope
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguessmovies.domain.model.SBGuessMoviesDomain
import com.example.smartbrainguessmovies.domain.usecase.SBGuessMoviesRequestUseCase
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigator
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService
import kotlinx.coroutines.launch

class SBStartGuessMoviesCompletionVm(
    service: SBFlowRouterService,
    private val navigator: SBGuessMoviesNavigator,
    private val useCase: SBGuessMoviesRequestUseCase,
) : SBBaseViewModel(service) {

    fun navigateToDetails() {
        viewModelScope.launch {
            val data = SBGuessMoviesDomain(level = 5, genre = "")
            useCase.execute(data)
            navigator.navigateToDetails()
        }
    }
}