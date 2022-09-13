package com.example.smartbraincomponents.components.or_divider

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.smartbraincomponents.databinding.SbCustomOrDividerBinding

class SBCustomOrDivider @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyle: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyle) {

    private val binding = SbCustomOrDividerBinding.inflate(LayoutInflater.from(context), this, true)
}