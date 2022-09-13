package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.ui

import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesListLayoutBinding
import com.example.smartbrainguesscharacters.feature.guess_movie.di.SBGuessMoviesFeatureComponentImpl
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter.SBGuessMoviesGenreListData
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter.SBGuessMoviesGenreListViewPager
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.vm.SBGuessMoviesListVm
import kotlin.reflect.KClass

class SBGuessMoviesListFragment : SBBaseFlowFragment<SBGuessMoviesListVm>() {

    override fun getViewModelClass(): KClass<SBGuessMoviesListVm> = SBGuessMoviesListVm::class

    override val screenLayout: Int = R.layout.sb_guess_movies_list_layout

    override fun defaultActionViewText(): Int = R.string.start_game

    override fun defaultAction() {
        vm?.navigateToDetails()
    }

    private val binding by viewBinding(SbGuessMoviesListLayoutBinding::bind)

    override fun initializeInjector() {
        SBGuessMoviesFeatureComponentImpl().moviesListModule().inject(this)
    }

    private val genreAdapter by lazy { SBGuessMoviesGenreListViewPager(this) }

    override fun onBindViewModel(vm: SBGuessMoviesListVm) {
        setUpRecyclerView()
        val genreHasMap: HashMap<Int, ArrayList<SBGuessMoviesGenreListData>> = hashMapOf()
        val movieList = listOf(
            SBGuessMoviesGenreListData("ფანტასტიკა"),
            SBGuessMoviesGenreListData("საშინელება"),
            SBGuessMoviesGenreListData("ქართული"),
            SBGuessMoviesGenreListData("სათავგადასავლო"),
            SBGuessMoviesGenreListData("მძაფრ-სიუჟეტიანი"),
            SBGuessMoviesGenreListData("ანიმაციური"),
            SBGuessMoviesGenreListData("მარველის სამყარო"),
            SBGuessMoviesGenreListData("DC სამყარო"),
            SBGuessMoviesGenreListData("დოკუმენტური"),
            SBGuessMoviesGenreListData("სერიალები"),
            SBGuessMoviesGenreListData("ისტორიული"),
            SBGuessMoviesGenreListData("მელოდრამა"),
            SBGuessMoviesGenreListData("თეატრები"),
            SBGuessMoviesGenreListData("ანიმეები"),
        )

        genreHasMap[genreHasMap.size] = arrayListOf()
        movieList.forEachIndexed { index, _ ->
            genreHasMap[genreHasMap.size - 1]?.add(movieList[index])
            if (((index + 1) % 6 == 0)) genreHasMap[genreHasMap.size] = arrayListOf()
        }

        genreAdapter.setData(genreHasMap)

        binding.moviesGenreViewPager.adapter = genreAdapter
        binding.viewPagerIndicator.setViewPager(binding.moviesGenreViewPager)
    }


    private fun setUpRecyclerView() {


    }
}