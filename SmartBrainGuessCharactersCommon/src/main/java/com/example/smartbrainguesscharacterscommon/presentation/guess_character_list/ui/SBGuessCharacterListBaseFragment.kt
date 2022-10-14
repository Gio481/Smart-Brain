package com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.ui

import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.base.SBBaseViewModel
import com.example.smartbrainguesscharacterscommon.domain.models.SBGuessCharacterListData
import com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.adapter.SBGuessCharacterListViewPager

abstract class SBGuessCharacterListBaseFragment<VM : SBBaseViewModel> : SBBaseFlowFragment<VM>() {

    protected val characterAdapter by lazy { SBGuessCharacterListViewPager(this) }

    abstract val guessCharacterList: List<SBGuessCharacterListData>
    abstract fun setUpRecyclerView()

    override fun onBindViewModel(vm: VM) {
        setUpRecyclerView()
        val characterHasMap: HashMap<Int, ArrayList<SBGuessCharacterListData>> = hashMapOf()
        characterHasMap[characterHasMap.size] = arrayListOf()
        guessCharacterList.forEachIndexed { index, _ ->
            characterHasMap[characterHasMap.size - 1]?.add(guessCharacterList[index])
            if (((index + 1) % 6 == 0)) characterHasMap[characterHasMap.size] = arrayListOf()
        }

        characterAdapter.setData(characterHasMap)
    }
}