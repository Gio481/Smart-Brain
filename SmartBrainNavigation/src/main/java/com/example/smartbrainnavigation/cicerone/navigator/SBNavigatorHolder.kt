package com.example.smartbrainnavigation.cicerone.navigator

interface SBNavigatorHolder {

    fun setNavigator(navigator: SBNavigator, hashCode: Int)

    fun removeNavigator(hashCode: Int)
}