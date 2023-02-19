package com.example.smartbrainhome.presentation.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ScrollView
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseView
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainhome.databinding.SbHomeCustomScrollViewBinding
import org.koin.java.KoinJavaComponent.get

class SBHomeCustomScrollView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
) : ScrollView(context, attrs, defStyle) {

    private val mySmartBrainViews: SBMySmartBrainViewProvider = get(SBMySmartBrainViewProvider::class.java)

    private val binding =
        SbHomeCustomScrollViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        mySmartBrainViews.getViews().forEach {
            addMySmartBrainContainers(it)
            val lp = it.layoutParams as MarginLayoutParams
            lp.bottomMargin = MARGIN_BOTTOM
            it.layoutParams = lp
        }
    }

    private fun addMySmartBrainContainers(view: SBMySmartBrainBaseView) {
        binding.mySmartBrainViewContainer.addView(view)
    }

    companion object {
        private const val MARGIN_BOTTOM = 100
    }
}
