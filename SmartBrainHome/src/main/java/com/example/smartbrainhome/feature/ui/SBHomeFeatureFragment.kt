package com.example.smartbrainhome.feature.ui

import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainhome.R
import com.example.smartbrainhome.databinding.SbHomeFeatureFragmentBinding
import com.example.smartbrainhome.di.SBHomeFeatureComponentImpl
import com.example.smartbrainhome.feature.vm.SBHomeFeatureViewModel
import kotlin.reflect.KClass


class SBHomeFeatureFragment : SBBaseFragment<SBHomeFeatureViewModel>() {

    override fun getViewModelClass(): KClass<SBHomeFeatureViewModel> = SBHomeFeatureViewModel::class

    override val screenLayout: Int = R.layout.sb_home_feature_fragment

    private val binding by viewBinding(SbHomeFeatureFragmentBinding::bind)

    override fun onDestroyComponents() {
        SBHomeFeatureComponentImpl().featureDestroy()
    }

    override fun onBindViewModel(vm: SBHomeFeatureViewModel) {

    }

}