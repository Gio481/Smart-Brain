package com.example.smartbrainthemaze.presentation.custom_view.maze_view.ui

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.smartbrainthemaze.R
import com.example.smartbrainthemaze.databinding.MazeBinding
import com.example.smartbrainthemaze.presentation.custom_view.maze_view.enum_classes.LeftSticksAmount
import com.example.smartbrainthemaze.presentation.custom_view.maze_view.enum_classes.RightSticksAmount
import com.example.smartbrainthemaze.util.addStickViewWithParams
import com.example.smartbrainthemaze.util.getStickAmount

class MazeView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet,
    defStyle: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyle) {

    private val binding = MazeBinding.inflate(LayoutInflater.from(context), this, true)

    private var leftSticksAmount: LeftSticksAmount? = null
        set(value) {
            value?.let { getLeftStickAmounts(it) }
            field = value
        }

    private var rightSticksAmount: RightSticksAmount = RightSticksAmount.One
        set(value) {
            getRightStickAmounts(value)
            field = value
        }

    private var topRightStickWidth: Int = DEFAULT_VALUE
    private var centerRightStickWidth: Int = 1
    private var bottomRightStickWidth: Int = DEFAULT_VALUE

    private var topRightStickMargin: Int = DEFAULT_VALUE
    private var bottomRightStickMargin: Int = DEFAULT_VALUE
    private var centerRightMarginTop: Int = DEFAULT_VALUE
    private var centerRightMarginBottom: Int = DEFAULT_VALUE

    private var topLeftStickWidth: Int = DEFAULT_VALUE
    private var centerLeftStickWidth: Int = 1
    private var bottomLeftStickWidth: Int = DEFAULT_VALUE

    private var topLeftStickMargin: Int = DEFAULT_VALUE
    private var bottomLeftStickMargin: Int = DEFAULT_VALUE
    private var centerLeftMarginTop: Int = DEFAULT_VALUE
    private var centerLeftMarginBottom: Int = DEFAULT_VALUE

    init {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MazeView, defStyle, 0)
        with(typedArray) {
            topRightStickWidth = getDimensionPixelSize(R.styleable.MazeView_topRightStickWidth, DEFAULT_VALUE)
            centerRightStickWidth = getDimensionPixelSize(R.styleable.MazeView_centerRightStickWidth, 1)
            bottomRightStickWidth = getDimensionPixelSize(R.styleable.MazeView_bottomRightStickWidth, DEFAULT_VALUE)
            topRightStickMargin = getDimensionPixelSize(R.styleable.MazeView_topRightStickMargin, DEFAULT_VALUE)
            bottomRightStickMargin = getDimensionPixelSize(R.styleable.MazeView_bottomRightStickMargin, DEFAULT_VALUE)
            centerRightMarginTop = getDimensionPixelSize(R.styleable.MazeView_centerRightStickMarginTop, DEFAULT_VALUE)
            centerRightMarginBottom = getDimensionPixelSize(R.styleable.MazeView_centerRightStickMarginBottom, DEFAULT_VALUE)
            rightSticksAmount = getStickAmount(binding.rightSticksContainer){
                RightSticksAmount.values()[getInt(R.styleable.MazeView_rightStickAmount, 0)]
            }!!
            topLeftStickWidth = getDimensionPixelSize(R.styleable.MazeView_topLeftStickWidth, DEFAULT_VALUE)
            centerLeftStickWidth = getDimensionPixelSize(R.styleable.MazeView_centerLeftStickWidth, 1)
            bottomLeftStickWidth = getDimensionPixelSize(R.styleable.MazeView_bottomLeftStickWidth, DEFAULT_VALUE)
            topLeftStickMargin = getDimensionPixelSize(R.styleable.MazeView_topLeftStickMargin, DEFAULT_VALUE)
            bottomLeftStickMargin = getDimensionPixelSize(R.styleable.MazeView_bottomLeftStickMargin, DEFAULT_VALUE)
            centerLeftMarginTop = getDimensionPixelSize(R.styleable.MazeView_centerLeftStickMarginTop, DEFAULT_VALUE)
            centerLeftMarginBottom = getDimensionPixelSize(R.styleable.MazeView_centerLeftStickMarginBottom, DEFAULT_VALUE)
            leftSticksAmount = getStickAmount(binding.leftSticksContainer){
                LeftSticksAmount.values()[getInt(R.styleable.MazeView_leftStickAmount, 0)]
            }
        }
        typedArray.recycle()
    }

    private fun getRightStickAmounts(sticksAmount: RightSticksAmount) {
        val layout = binding.rightSticksContainer
        when (sticksAmount) {
            RightSticksAmount.One -> {
                addStickViewWithParams(layout, centerRightStickWidth) {
                    topMargin = centerRightMarginTop
                    bottomMargin = centerRightMarginBottom
                    gravity = Gravity.CENTER_VERTICAL
                }
            }
            RightSticksAmount.Two -> {
                addStickViewWithParams(layout, topRightStickWidth) {
                    topMargin = topRightStickMargin
                    gravity = Gravity.TOP
                }
                addStickViewWithParams(layout, bottomRightStickWidth) {
                    bottomMargin = bottomRightStickMargin
                    gravity = Gravity.BOTTOM
                }
            }
            RightSticksAmount.Three -> {
                addStickViewWithParams(layout, topRightStickWidth) {
                    topMargin = topRightStickMargin
                    gravity = Gravity.TOP
                }
                addStickViewWithParams(layout, centerRightStickWidth) {
                    topMargin = topRightStickMargin
                    bottomMargin = bottomRightStickMargin
                    gravity = Gravity.CENTER_VERTICAL
                }
                addStickViewWithParams(layout, bottomRightStickWidth) {
                    bottomMargin = bottomRightStickMargin
                    gravity = Gravity.BOTTOM
                }
            }
        }
    }


    private fun getLeftStickAmounts(sticksAmount: LeftSticksAmount) {
        val layout = binding.leftSticksContainer
        when (sticksAmount) {
            LeftSticksAmount.One -> {
                addStickViewWithParams(layout, centerLeftStickWidth) {
                    topMargin = centerLeftMarginTop
                    bottomMargin = centerLeftMarginBottom
                    gravity = Gravity.CENTER_VERTICAL
                }
            }
            LeftSticksAmount.Two -> {
                addStickViewWithParams(layout, topLeftStickWidth) {
                    topMargin = topLeftStickMargin
                    gravity = Gravity.getAbsoluteGravity(Gravity.TOP, LAYOUT_DIRECTION_RTL)
                }
                addStickViewWithParams(layout, bottomLeftStickWidth) {
                    bottomMargin = bottomLeftStickMargin
                    gravity = Gravity.getAbsoluteGravity(Gravity.BOTTOM, LAYOUT_DIRECTION_RTL)
                }
            }
            LeftSticksAmount.Three -> {
                addStickViewWithParams(layout, topLeftStickWidth) {
                    topMargin = topLeftStickMargin
                    gravity = Gravity.TOP
                }
                addStickViewWithParams(layout, centerLeftStickWidth) {
                    topMargin = topLeftStickMargin
                    bottomMargin = bottomLeftStickMargin
                    gravity = Gravity.CENTER_VERTICAL
                }
                addStickViewWithParams(layout, bottomLeftStickWidth) {
                    bottomMargin = bottomLeftStickMargin
                    gravity = Gravity.getAbsoluteGravity(Gravity.BOTTOM, LAYOUT_DIRECTION_RTL)
                }
            }
        }
    }

    companion object {
        private const val DEFAULT_VALUE = 1
    }

}