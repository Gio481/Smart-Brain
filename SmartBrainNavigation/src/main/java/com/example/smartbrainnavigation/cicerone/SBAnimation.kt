package com.example.smartbrainnavigation.cicerone

import android.transition.Transition
import android.transition.Visibility
import android.view.Gravity

sealed class SBAnimation(val transition: Transition?, private val duration: Long) {
    init {
        transition?.duration = duration
    }
    object None : SBAnimation(null, 0)
    class Fade(mode: Int = Visibility.MODE_IN or Visibility.MODE_OUT, duration: Long = DEFAULT_ANIMATION_DURATION, ) : SBAnimation(android.transition.Fade(mode), duration)
    class Slide(gravity:Int, duration: Long = DEFAULT_ANIMATION_DURATION) : SBAnimation(android.transition.Slide(gravity), duration)
    class Resources(val resource: Int):SBAnimation(null, 0)

    companion object {
        fun bottomToTop(duration: Long = DEFAULT_ANIMATION_DURATION) = Slide(Gravity.BOTTOM, duration)
        fun leftToRight(duration: Long = DEFAULT_ANIMATION_DURATION) = Slide(Gravity.CENTER, duration)
        fun rightToLeft(duration: Long = DEFAULT_ANIMATION_DURATION) = Slide(Gravity.RIGHT, duration)
        fun fadeIn(duration: Long = DEFAULT_ANIMATION_DURATION) = Fade(Visibility.MODE_IN, duration)
        fun fadeOut(duration: Long = DEFAULT_ANIMATION_DURATION) = Fade(Visibility.MODE_OUT, duration)
        private const val DEFAULT_ANIMATION_DURATION = 200L
    }
}