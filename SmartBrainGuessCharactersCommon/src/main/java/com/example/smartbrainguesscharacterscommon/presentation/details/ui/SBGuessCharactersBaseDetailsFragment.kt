package com.example.smartbrainguesscharacterscommon.presentation.details.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacterscommon.R
import com.example.smartbrainguesscharacterscommon.databinding.SbGuessCharacterDetailsFragmentBinding
import com.example.smartbrainguesscharacterscommon.databinding.SbGuessCharacterListChildFragmentBinding
import com.example.smartbrainguesscharacterscommon.presentation.details.adapter.SBGuessCharacterDetailsAdapter
import kotlin.reflect.KClass

class SBGuessCharactersBaseDetailsFragment<VM:SBBaseViewModel> : SBBaseFlowFragment<VM>() {

    override fun showBackButton(): Boolean = false

    private lateinit var levelAdapter: SBGuessCharacterDetailsAdapter
    override val screenLayout: Int = R.layout.sb_guess_character_details_fragment

    private val binding by viewBinding(SbGuessCharacterDetailsFragmentBinding::bind)

    override fun showActionView(): Boolean = false


    override fun onBindViewModel(vm: VM) {
        super.onBindViewModel(vm)

        val list = mutableListOf<Int>()
        for (i in 1..15) {
            list.add(i)
        }

        levelAdapter = SBGuessCharacterDetailsAdapter(3)
        levelAdapter.setData(list)

        with(binding.myProgressRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = levelAdapter
        }
    }
}