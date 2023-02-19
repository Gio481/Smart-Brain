package com.example.smartbrainguesscharacterscommon.presentation.components.my_smart_brain

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguesscharacterscommon.databinding.MySmartBrainChildViewBinding

@SuppressLint("ViewConstructor")
class SBGuessCharacterMySmartBrainChildView(
    context: Context,
    childViewList: List<SBMySmartBrainBaseChildView>,
) : SBMySmartBrainBaseChildView(context) {

    private val binding = MySmartBrainChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        childViewList.forEach {
            binding.childViewContainer.addView(it)
            val lp = it.layoutParams as LinearLayout.LayoutParams
            lp.bottomMargin = 20
            lp.topMargin = 20
            it.layoutParams = lp
        }
    }
}