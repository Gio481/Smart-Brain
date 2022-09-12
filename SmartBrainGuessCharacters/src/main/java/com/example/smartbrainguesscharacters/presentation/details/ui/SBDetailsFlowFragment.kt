package com.example.smartbrainguesscharacters.presentation.details.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.databinding.SbDetailsLayoutBinding
import com.example.smartbrainguesscharacters.feature.details.di.SBDetailsFeatureComponentImpl
import com.example.smartbrainguesscharacters.presentation.details.adapter.SBDetailsAdapter
import com.example.smartbrainguesscharacters.presentation.details.vm.SBDetailsFlowVm
import kotlin.reflect.KClass

class SBDetailsFlowFragment : SBBaseFlowFragment<SBDetailsFlowVm>() {

    override fun getViewModelClass(): KClass<SBDetailsFlowVm> = SBDetailsFlowVm::class

    override val screenLayout: Int = R.layout.sb_details_layout

    override fun showBackButton(): Boolean = false


    private lateinit var levelAdapter: SBDetailsAdapter

    private val binding by viewBinding(SbDetailsLayoutBinding::bind)

    override fun showActionView(): Boolean = false
    override fun initializeInjector() {
        SBDetailsFeatureComponentImpl().detailsFlowModule().inject(this)
    }

    override fun onBindViewModel(vm: SBDetailsFlowVm) {
        val list = mutableListOf<Int>()
        for (i in 1..15) {
            list.add(i)
        }

        levelAdapter = SBDetailsAdapter(3)
        levelAdapter.setData(list)
        SBDetailsFeatureComponentImpl().detailsFlowModule().inject(this)

        with(binding.myProgressRecyclerView) {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = levelAdapter
        }
    }
}