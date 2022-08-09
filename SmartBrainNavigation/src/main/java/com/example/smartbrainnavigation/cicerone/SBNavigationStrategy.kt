package com.example.smartbrainnavigation.cicerone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

interface SBNavigationStrategy<T : SBBaseScreen> {
    fun setUpAnimation(
        screen: T,
        transaction: FragmentTransaction,
        fragment: Fragment,
        backStackSize: Int,
    )
}