package com.example.smartbraincomponents.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import com.example.smartbraincomponents.databinding.MySmartBrainContainerBinding

abstract class SBMySmartBrainViewContainer(
    context: Context,
) : SBMySmartBrainBaseView(context) {

    private val binding by lazy {
        MySmartBrainContainerBinding.inflate(LayoutInflater.from(context), this, true)
    }

    @StringRes
    protected abstract fun mySmartBrainTitle(): Int

    abstract val view: SBMySmartBrainBaseChildView


    init {
        binding.mySmartBrainHeaderView.titleText = context.getString(this.mySmartBrainTitle())
    }

    fun successState() {
//        view.data = data
//        initHeaderViewForChild()
        drawView(view)
//        d("giorgi", "$view")
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