package com.example.smartbrainsplash.presentation.main.ui

import android.annotation.SuppressLint
import com.example.smartbraincomponents.base.SBBaseFragment
import com.example.smartbraincomponents.util.viewBinding
import com.example.smartbrainsplash.R
import com.example.smartbrainsplash.databinding.SbSplashFragmentBinding
import com.example.smartbrainsplash.presentation.main.vm.SBSplashViewModel
import kotlin.reflect.KClass

class SBSplashFragment : SBBaseFragment<SBSplashViewModel>() {

    override val screenLayout: Int = R.layout.sb_splash_fragment

    override fun getViewModelClass(): KClass<SBSplashViewModel> = SBSplashViewModel::class

    private val binding by viewBinding(SbSplashFragmentBinding::bind)

    @SuppressLint("SetTextI18n")
    override fun onBindViewModel(vm: SBSplashViewModel) {
        binding.testingTextView.text = "yes"
    }
}