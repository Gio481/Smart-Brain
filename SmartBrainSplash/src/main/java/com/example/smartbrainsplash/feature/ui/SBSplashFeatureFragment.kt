package com.example.smartbrainsplash.feature.ui

import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbrainsplash.R
import com.example.smartbrainsplash.di.SBSplashFeatureComponentImpl
import com.example.smartbrainsplash.feature.vm.SBSplashFeatureViewModel
import kotlin.reflect.KClass

class SBSplashFeatureFragment : SBBaseFragment<SBSplashFeatureViewModel>() {

    override val screenLayout: Int = R.layout.sb_splash_fragment

    override fun getViewModelClass(): KClass<SBSplashFeatureViewModel> = SBSplashFeatureViewModel::class

    override fun onDestroyComponents() = SBSplashFeatureComponentImpl().featureDestroy()
}