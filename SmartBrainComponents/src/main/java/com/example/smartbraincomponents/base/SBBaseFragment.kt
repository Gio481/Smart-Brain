package com.example.smartbraincomponents.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.getKoinScope
import org.koin.androidx.viewmodel.ext.android.getSharedStateViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass

abstract class SBBaseFragment<VM : SBBaseViewModel> : Fragment() {

    protected abstract val screenLayout: Int?

    protected var vm: VM? = null

    protected abstract fun getViewModelClass(): KClass<VM>

    abstract fun onBindViewModel(vm: VM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = getSharedStateViewModel(clazz = getViewModelClass())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return if (screenLayout != null) {
            inflater.inflate(screenLayout!!, container, false)
        } else {
            super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm?.let { onBindViewModel(it) }
    }
}