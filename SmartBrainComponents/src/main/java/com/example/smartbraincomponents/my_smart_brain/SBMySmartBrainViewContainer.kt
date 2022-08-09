package com.example.smartbraincomponents.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.smartbraincomponents.databinding.MySmartBrainContainerBinding
import com.example.smartbraincomponents.view_provider.SBViewProvider

abstract class SBMySmartBrainViewContainer<DATA>(
    context: Context
) : SBMySmartBrainBaseView(context), SBViewProvider {

    private val binding by lazy {
        MySmartBrainContainerBinding.inflate(LayoutInflater.from(context), this, true)
    }

    @StringRes
    protected abstract fun mySmartBrainTitle(): Int

    protected abstract val view: SBMySmartBrainBaseChildView<DATA>

    init {
        binding.mySmartBrainHeaderView.titleText = context.getString(this.mySmartBrainTitle())
    }

    fun successState(data: DATA) {
        view.data = data
        initHeaderViewForChild()
        drawView(view)
    }

    private fun drawView(view: ViewGroup) {
        post {
            if (isViewAlreadyChild(view)) {
                binding.mySmartBrainContainerView.removeAllViews()
                binding.mySmartBrainContainerView.addView(view)
            }
        }
    }

    private fun isViewAlreadyChild(view: ViewGroup): Boolean {
        return indexOfChild(view) == -1
    }

    private fun initHeaderViewForChild() {
        if (view.itemHeaderView == null) {
            view.itemHeaderView = binding.mySmartBrainHeaderView
        }
    }
}