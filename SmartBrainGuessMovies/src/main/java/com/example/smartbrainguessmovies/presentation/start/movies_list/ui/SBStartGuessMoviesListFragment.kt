package com.example.smartbrainguessmovies.presentation.start.movies_list.ui

import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacterscommon.domain.models.SBGuessCharacterListData
import com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.ui.SBGuessCharacterListBaseFragment
import com.example.smartbrainguessmovies.R
import com.example.smartbrainguessmovies.databinding.SbStartGuessMoviesListFragmentBinding
import com.example.smartbrainguessmovies.feature.start.di.SBStartGuessMoviesFeatureComponentImpl
import com.example.smartbrainguessmovies.presentation.start.movies_list.vm.SBStartGuessMoviesListVm

class SBStartGuessMoviesListFragment : SBGuessCharacterListBaseFragment<SBStartGuessMoviesListVm>() {

    override fun getViewModelClass() = SBStartGuessMoviesListVm::class

    override val screenLayout: Int = R.layout.sb_start_guess_movies_list_fragment

    private val binding by viewBinding(SbStartGuessMoviesListFragmentBinding::bind)

    override fun defaultAction() {
        vm?.next()
    }

    override fun initializeInjector() {
        SBStartGuessMoviesFeatureComponentImpl().moviesListModule().inject(this)
    }

    override val guessCharacterList = listOf(
        SBGuessCharacterListData("3og"),
        SBGuessCharacterListData("poeiwrkfewf"),
        SBGuessCharacterListData("wpif "),
        SBGuessCharacterListData("apijejif"),
        SBGuessCharacterListData("giorog"),
        SBGuessCharacterListData("dkoa"),
        SBGuessCharacterListData("poskvsdv"),
        SBGuessCharacterListData("pkogr"),
        SBGuessCharacterListData("aijeif"),
        SBGuessCharacterListData("iomwivnrv"),
        SBGuessCharacterListData("osmidnvcdv"),
    )

    override fun setUpRecyclerView() {

    }

    override fun onBindViewModel(vm: SBStartGuessMoviesListVm) {
        super.onBindViewModel(vm)
        binding.moviesGenreViewPager.adapter = characterAdapter
    }
}