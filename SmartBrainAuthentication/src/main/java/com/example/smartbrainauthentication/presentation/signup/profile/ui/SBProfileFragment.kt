package com.example.smartbrainauthentication.presentation.signup.profile.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartbrainauthentication.R
import com.example.smartbrainauthentication.databinding.SbAuthenticationProfileFragmentBinding
import com.example.smartbrainauthentication.feature.signup.di.SBSignUpFeatureComponentImpl
import com.example.smartbrainauthentication.presentation.signup.profile.adapter.SBLocalProfileAdapter
import com.example.smartbrainauthentication.presentation.signup.profile.adapter.SBLocalProfileData
import com.example.smartbrainauthentication.presentation.signup.profile.vm.SBProfileViewModel
import com.example.smartbraincomponents.base.SBBaseFlowFragment
import com.example.smartbraincomponents.extension.viewBinding
import kotlin.reflect.KClass

class SBProfileFragment : SBBaseFlowFragment<SBProfileViewModel>() {

    override fun getViewModelClass(): KClass<SBProfileViewModel> = SBProfileViewModel::class

    override val screenLayout: Int = R.layout.sb_authentication_profile_fragment

    override fun showBackButton(): Boolean = true


    private val binding by viewBinding(SbAuthenticationProfileFragmentBinding::bind)

    override fun defaultActionViewText(): Int = R.string.sign_up

    override fun defaultAction() {
        vm?.signUp()
    }

    override fun initializeInjector() {
        SBSignUpFeatureComponentImpl().profileModule().inject(this)
    }

    private val adapter by lazy { SBLocalProfileAdapter() }

    override fun onBindViewModel(vm: SBProfileViewModel) {
        val list = listOf(
            SBLocalProfileData(R.drawable.local_profile_1),
            SBLocalProfileData(R.drawable.local_image_2),
            SBLocalProfileData(R.drawable.local_image_3),
            SBLocalProfileData(R.drawable.local_image_4)
        )

        binding.localImageRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.localImageRecyclerView.adapter = adapter

        adapter.setData(list)
    }
}