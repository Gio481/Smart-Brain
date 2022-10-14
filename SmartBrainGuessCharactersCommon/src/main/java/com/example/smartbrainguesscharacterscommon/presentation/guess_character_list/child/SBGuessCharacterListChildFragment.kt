package com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.child

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacterscommon.R
import com.example.smartbrainguesscharacterscommon.databinding.SbGuessCharacterListChildFragmentBinding
import com.example.smartbrainguesscharacterscommon.domain.models.SBGuessCharacterListData
import com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.adapter.SBGuessCharacterListAdapter

class SBGuessCharacterListChildFragment : SBBaseFragment<SBBaseViewModel>() {

    override val screenLayout: Int = R.layout.sb_guess_character_list_child_fragment
    private val binding by viewBinding(SbGuessCharacterListChildFragmentBinding::bind)

    private lateinit var genreListData: List<SBGuessCharacterListData>
    private val genreAdapter by lazy { SBGuessCharacterListAdapter() }


    fun initData(genreList: List<SBGuessCharacterListData>) {
        genreListData = genreList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.guessCharacterListRecyclerView) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = genreAdapter
        }
        genreAdapter.setData(genreListData)
    }
}