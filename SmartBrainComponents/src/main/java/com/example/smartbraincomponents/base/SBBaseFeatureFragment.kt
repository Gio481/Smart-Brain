package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.smartbraincomponents.databinding.SbBaseFragmentsLayoutBinding
import com.example.smartbraincomponents.util.injectNavigatorHolder
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FLOW
import com.example.smartbrainnavigation.cicerone.navigator.SBFlowNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator
import org.koin.android.ext.android.get

abstract class SBBaseFeatureFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>() {

    private lateinit var binding: SbBaseFragmentsLayoutBinding
    private val navigatorHolder by injectNavigatorHolder()
    private val navigator: SBNavigator by lazy { SBFlowNavigator(this, vm?.router, get(CICERONE_FLOW)) }

    @StringRes
    abstract fun getTitleResId(): Int?

    abstract fun getStartFragment():Fragment

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
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder?.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder?.removeNavigator()
        super.onPause()
    }

    private fun getTitle() = getTitleResId()?.let { binding.fragmentTitle.setText(it) }

    private fun startFragment(fragment: Fragment){
       val transaction = childFragmentManager.beginTransaction()
    }

}

abstract class SBBaseFlowFragment<VM : SBBaseViewModel> : SBBaseFragment<VM>()