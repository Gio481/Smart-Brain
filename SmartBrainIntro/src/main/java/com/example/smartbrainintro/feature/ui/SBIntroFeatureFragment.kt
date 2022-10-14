package com.example.smartbrainintro.feature.ui

import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbraincomponents.extension.viewBinding
import com.example.smartbrainintro.R
import com.example.smartbrainintro.databinding.SbIntroFeatureFragmentBinding
import com.example.smartbrainintro.di.SBIntroFeatureComponentImpl
import com.example.smartbrainintro.feature.vm.SBIntroFeatureViewModel
import com.example.smartbrainintro.presentation.adapter.SBIntroAdapter
import com.example.smartbrainintro.presentation.onboarding.BlankFragment
import kotlin.reflect.KClass

class SBIntroFeatureFragment : SBBaseFragment<SBIntroFeatureViewModel>() {

    override fun getViewModelClass(): KClass<SBIntroFeatureViewModel> =
        SBIntroFeatureViewModel::class

    override val screenLayout: Int = R.layout.sb_intro_feature_fragment

    private val binding by viewBinding(SbIntroFeatureFragmentBinding::bind)

    private val list = listOf(BlankFragment(), BlankFragment(), BlankFragment(), BlankFragment())

    private val mAdapter by lazy {
        SBIntroAdapter(list, this)
    }

    override fun onDestroyComponents() {
        SBIntroFeatureComponentImpl().featureDestroy()
    }

    override fun onBindViewModel(vm: SBIntroFeatureViewModel) {
        binding.onBoardingViewPager.adapter = mAdapter
        binding.viewPagerCutomCircleIndicator.setViewPager(binding.onBoardingViewPager)
        binding.signInButton.setOnClickListener {
            vm.navigateToSignIn()
        }
        binding.signUpButton.setOnClickListener {
            vm.navigateToSignUp()
        }
    }


}