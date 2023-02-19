package com.example.smartbraincomponents.my_smart_brain

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout

open class SBMySmartBrainBaseView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttrs: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttrs)