package com.example.smartbrainhome.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ScrollView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainhome.databinding.SbHomeCustomScrollViewBinding
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SBHomeCustomScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ScrollView(context, attrs, defStyle) {

    private val koinComponentInstance = KoinComponentInstance()
    private val binding = SbHomeCustomScrollViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        koinComponentInstance.mySmartBrain.getViews().forEach {
            addMySmartBrainView(it)
        }
    }

    private fun addMySmartBrainView(view: SBMySmartBrainBaseView) {
        binding.mySmartBrainViewContainer.addView(view)
    }

    class KoinComponentInstance : KoinComponent {
        val mySmartBrain: SBMySmartBrainViewProvider by inject()
    }
}
