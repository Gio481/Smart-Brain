package com.example.smartbraincomponents.components.indicator

import android.content.Context
import android.util.AttributeSet
import android.util.Log.d
import android.view.View
import android.widget.LinearLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.smartbraincomponents.R

class SBViewPagerCircleIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyle: Int = 0,
) : LinearLayout(context, attrs, defStyle) {

    private lateinit var viewPager: ViewPager2
    private var indicatorMargin = DEFAULT_INDEX
    private var circleIndicatorSize = DEFAULT_INDEX
    private var lastPosition = DEFAULT_INDEX
    private var activeIndicator = DEFAULT_INDEX
    private var inactiveIndicator = DEFAULT_INDEX

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SBViewPagerCircleIndicator, defStyle, 0)
        indicatorMargin = typedArray.getDimensionPixelSize(R.styleable.SBViewPagerCircleIndicator_circleIndicatorMargin, DEFAULT_INDEX)
        activeIndicator = typedArray.getResourceId(R.styleable.SBViewPagerCircleIndicator_activeCircleBackground, DEFAULT_INDEX)
        inactiveIndicator = typedArray.getResourceId(R.styleable.SBViewPagerCircleIndicator_inactiveCircleBackground, DEFAULT_INDEX)
        circleIndicatorSize = typedArray.getDimensionPixelSize(R.styleable.SBViewPagerCircleIndicator_circleIndicatorSize, DEFAULT_INDEX)
        typedArray.recycle()
    }

    fun setViewPager(viewPager2: ViewPager2) {
        viewPager = viewPager2
        if (viewPager.adapter != null) {
            lastPosition = DEFAULT_INDEX
            createIndicator()
            viewPager.unregisterOnPageChangeCallback(pageChangeListener)
            viewPager.registerOnPageChangeCallback(pageChangeListener)
            pageChangeListener.onPageSelected(viewPager.currentItem)
        }
    }

    private val pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            if (viewPager.adapter != null && viewPager.adapter!!.itemCount < 0) {
                return
            }
            val currentIndicator = getChildAt(lastPosition)
            if (lastPosition >= 0 && currentIndicator != null) {
                currentIndicator.setBackgroundResource(inactiveIndicator)
            }

            val selectedIndicator = getChildAt(position)
            selectedIndicator?.setBackgroundResource(activeIndicator)
            lastPosition = position
        }
    }

    private fun createIndicator() {
        removeAllViews()
        val count: Int = viewPager.adapter?.itemCount!!
        if (count <= 0) {
            return
        }
        val currentItem: Int = viewPager.currentItem

        d("giorgi","${viewPager.currentItem}")

        for (i in 0 until count) {
            if (currentItem == i) {
                addIndicator(activeIndicator)
            } else {
                addIndicator(inactiveIndicator)
            }
        }
    }

    private fun addIndicator(indicator: Int) {
        val indicatorView = View(context)
        indicatorView.setBackgroundResource(indicator)
        addView(indicatorView, circleIndicatorSize, circleIndicatorSize)
        val lp = indicatorView.layoutParams as LayoutParams
        lp.marginStart = indicatorMargin
        lp.marginEnd = indicatorMargin
        indicatorView.layoutParams = lp
    }

    companion object {
        private const val DEFAULT_INDEX = -1
    }
}