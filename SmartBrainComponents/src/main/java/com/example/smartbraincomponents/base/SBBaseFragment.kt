package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.getStateViewModel
import kotlin.reflect.KClass

abstract class SBBaseFragment<VM : SBBaseViewModel> : Fragment() {

    protected open val screenLayout: Int = 0

    protected var vm: VM? = null

    protected open fun getViewModelClass(): KClass<VM>? = null

    protected open fun onBindViewModel(vm: VM) {}

    protected open fun onDestroyComponents() {}

    open fun onBackPressed(): Boolean = false

    protected open fun initializeInjector() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        initializeInjector()
        super.onCreate(savedInstanceState)
        if (getViewModelClass() != null) {
            vm = getStateViewModel(clazz = getViewModelClass()!!)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return if (screenLayout != 0) {
            inflater.inflate(screenLayout, container, false)
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm?.let { onBindViewModel(it) }
    }

    override fun onDestroy() {
        onDestroyComponents()
        super.onDestroy()
    }
}