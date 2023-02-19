package com.example.smartbrainthemaze.feature.play.ui

import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainthemaze.feature.play.di.FeatureComponentImpl
import com.example.smartbrainthemaze.feature.play.vm.FeatureVm

class FeatureUI : SBBaseFeatureFragment<FeatureVm>() {

    override fun getViewModelClass() = FeatureVm::class

    override fun onDestroyComponents() {
        FeatureComponentImpl().featureDestroy()
    }
}