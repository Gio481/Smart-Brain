package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.databinding.SbBaseFragmentsLayoutBinding
import com.example.smartbraincomponents.extension.inflate
import com.example.smartbraincomponents.extension.injectNavigatorHolder
import com.example.smartbraincomponents.util.SBFlowNavigator
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FLOW
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator
import org.koin.android.ext.android.get

abstract class SBBaseFeatureFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>() {

    private lateinit var binding: SbBaseFragmentsLayoutBinding

    private val navigatorHolder by injectNavigatorHolder()
    private val navigator: SBNavigator by lazy {
        SBFlowNavigator(this,
            vm?.router,
            get(CICERONE_FLOW))
    }

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
        binding.backButton.setOnClickListener {
            childFragmentManager.popBackStack()
        }
        binding.closeButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    fun setUpActions(fragment: SBBaseFlowFragment<*>) {
        with(binding) {
            with(fragment) {
                backButton.isVisible = showBackButton()
                val actionView = fragmentActionView.inflate(actionView())
                if (actionView() == R.layout.sb_default_action_view_layout) {
                    actionView.findViewById<TextView>(R.id.nextButtonTextView).apply {
                        text = requireContext().getString(defaultActionViewText())
                    }
                    actionView.findViewById<ImageView>(R.id.nextButtonArrowImageView).apply {
                        isVisible = defaultActionViewArrowVisibility()
                    }
                }
                actionView.findViewById<ViewGroup>(R.id.actionView).apply {
                    setOnClickListener { defaultAction() }
                }
                if (showActionView()) fragmentActionView.addView(actionView)

            }
        }
    }

    private fun getCurrentFragment(): SBBaseFlowFragment<*>? {
        return (childFragmentManager.findFragmentById(R.id.fragmentBaseContainer)) as? SBBaseFlowFragment<*>
    }

    override fun onBackPressed(): Boolean {
        if (getCurrentFragment()?.onBackPressed() == true) return true
        if (getCurrentFragment()?.showBackButton()==false) return true
        return if (childFragmentManager.backStackEntryCount == 1) {
            parentFragmentManager.popBackStack()
            true
        } else {
            childFragmentManager.popBackStack()
            true
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder?.setNavigator(navigator)
    }


    override fun onPause() {
        navigatorHolder?.removeNavigator()
        super.onPause()
    }

    private fun getTitle() {
        binding.fragmentTitle.text = getTitleResId()?.let { requireContext().getString(it) } ?: ""
    }
}