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
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator

abstract class SBBaseFeatureFragment<VM : SBBaseViewModel> : SBBaseFunctionsFragment<VM>() {

    private lateinit var binding: SbBaseFragmentsLayoutBinding

    private val navigatorHolder by injectNavigatorHolder()
    private val navigator: SBNavigator by lazy { SBFlowNavigator(this, vm?.router) }

    @StringRes
    protected open fun getTitleResId(): Int? = null

    abstract fun isChildFragmentFlowPart(): Boolean

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = SbBaseFragmentsLayoutBinding.inflate(inflater, container, false)
        return if(isChildFragmentFlowPart()) super.onCreateView(inflater, container, savedInstanceState)
        else binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getTitle()
        giorgi()
        binding.backButton.isVisible = showBackButton()
    }

    open fun s():Int{
        return R.string.next
    }

    protected fun setUpActions() {
        with(binding) {
            val actionView = fragmentActionView.inflate(actionView())

            if (actionView() == R.layout.sb_default_action_view_layout) {
                actionView.findViewById<TextView>(R.id.nextButtonTextView).apply {
                    text = requireContext().getString(s())
                }
                actionView.findViewById<ImageView>(R.id.nextButtonArrowImageView).apply {
                    isVisible = defaultActionViewArrowVisibility()
                }
            }

            if (showActionView()) fragmentActionView.addView(actionView)

            actionView.findViewById<TextView>(R.id.nextButtonTextView).apply {
                setOnClickListener {
                    defaultActionListener?.invoke()
                }
            }
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