package com.example.smartbrainnavigation.cicerone

import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorHolder

class SBCicerone<T : SBBaseRouter>(private val router: T) {

    fun getNavigatorHolder(): SBNavigatorHolder = router.commandBuffer

    companion object {
        fun <T : SBBaseRouter> create(customRouter: T) = SBCicerone(customRouter)
    }
}