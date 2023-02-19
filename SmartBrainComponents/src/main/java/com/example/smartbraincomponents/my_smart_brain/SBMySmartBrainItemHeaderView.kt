package com.example.smartbraincomponents.my_smart_brain

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.databinding.MySmartBrainItemHeaderViewBinding

class SBMySmartBrainItemHeaderView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyleAttrs) {

    private val binding =
        MySmartBrainItemHeaderViewBinding.inflate(LayoutInflater.from(context), this, true)

    var titleText: String? = null
        set(value) {
            binding.mySmartBrainHeaderItemTitle.text = value
            field = value
        }

    var isArrowShown: ArrowVisibility? = null
        set(value) {
            binding.mySmartBrainHeaderItemArrow.isVisible = value == ArrowVisibility.Visible
            field = value
        }

    init {
        attributeSet?.let {
            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.SBMySmartBrainItemHeaderView,
                defStyleAttrs,
                0)
            titleText = typedArray.getString(R.styleable.SBMySmartBrainItemHeaderView_titleText)
            isArrowShown = ArrowVisibility.values()[typedArray.getInt(R.styleable.SBMySmartBrainItemHeaderView_titleArrowShowType, 0)]
            typedArray.recycle()
        }
    }

    enum class ArrowVisibility(val value: Int) {
        Visible(0),
        Invisible(1)
    }
}