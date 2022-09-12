package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.child

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesListChildFragmentLayoutBinding
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter.SBGuessMoviesGenreListAdapter
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter.SBGuessMoviesGenreListData

class SBGuessMoviesListChildFragment : SBBaseFragment<SBBaseViewModel>() {


    override val screenLayout: Int = R.layout.sb_guess_movies_list_child_fragment_layout
    private val binding by viewBinding(SbGuessMoviesListChildFragmentLayoutBinding::bind)

    private lateinit var genreListData: List<SBGuessMoviesGenreListData>
    private val genreAdapter by lazy { SBGuessMoviesGenreListAdapter() }


    fun initData(genreList: List<SBGuessMoviesGenreListData>) {
        genreListData = genreList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.moviesListRecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = genreAdapter
        }
        genreAdapter.setData(genreListData)
    }
}