package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.databinding.SbBaseFragmentsLayoutBinding
import com.example.smartbraincomponents.util.SBFlowNavigator
import com.example.smartbraincomponents.util.injectNavigatorHolder
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator

abstract class SBBaseFeatureFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>() {

    private lateinit var binding: SbBaseFragmentsLayoutBinding
    private val navigatorHolder by injectNavigatorHolder()
    private val navigator: SBNavigator by lazy { SBFlowNavigator(this, vm?.router) }

    @StringRes
    protected open fun getTitleResId(): Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return SbBaseFragmentsLayoutBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTitle()
        binding.backButton.isVisible = true
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder?.removeNavigator()
        super.onPause()
    }

    // dzaan droebit sanam gavasworeb
    fun startFragment(fragment: SBBaseScreen) {
        val s = childFragmentManager.beginTransaction()
        s.replace(R.id.fragmentBaseContainer, fragment.getFragment(), fragment.screenKey)
        s.commit()
    }

    private fun getTitle() {
        binding.fragmentTitle.text = getTitleResId()?.let { requireContext().getString(it) } ?: ""
    }
}