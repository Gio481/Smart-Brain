package com.example.smartbrainthemaze.util

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.smartbraincomponents.R
import com.example.smartbraincomponents.extension.toDp

fun ViewGroup.addStickViewWithParams(
    layout: FrameLayout,
    width: Int,
    view: View = getView(),
    block: (FrameLayout.LayoutParams.() -> Unit)? = null,
) {
    addStickView(layout, view, width)
    val lp = view.layoutParams as FrameLayout.LayoutParams
    block?.let { getView().layoutParams = lp.apply(it) }
}

private fun ViewGroup.addStickView(layout: FrameLayout, view: View, width: Int) {
    layout.addView(view, width, 2.toDp(resources))
}

private fun ViewGroup.getView(): View {
    val view = View(context)
    view.setBackgroundColor(ContextCompat.getColor(context, R.color.black))
    return view
}

inline fun <T> getStickAmount(view: View, tryAction: () -> T): T? {
    return try {
        tryAction.invoke()
    } catch (e: Exception) {
        view.isVisible = false
        null
    }
}