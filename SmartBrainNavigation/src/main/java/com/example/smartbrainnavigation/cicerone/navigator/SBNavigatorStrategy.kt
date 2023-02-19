package com.example.smartbrainnavigation.cicerone.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

interface SBNavigatorStrategy<T : SBBaseScreen> {
    fun setUpTransaction(
        screen: T,
        currentFragment: Fragment?,
        fragment: Fragment,
        transaction: FragmentTransaction,
        backStackSize: Int,
    )
}