package com.example.smartbrainnavigation.cicerone

import android.os.Handler
import android.os.Looper
import com.example.smartbrainnavigation.cicerone.command.SBCiceroneCommand
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorHolder

internal class SBCommandBuffer : SBNavigatorHolder {

    private var navigators = mutableListOf<SBCommandBufferItem>()
    private var currentNavigator: SBCommandBufferItem? = null
    private val pendingCommands = mutableListOf<Array<out SBCiceroneCommand>>()
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun setNavigator(navigator: SBNavigator, hashCode: Int) {
        navigators.add(SBCommandBufferItem(hashCode, navigator).also { currentNavigator = it })
        pendingCommands.forEach { currentNavigator?.navigator?.applyCommands(it) }
        pendingCommands.clear()
    }

    override fun removeNavigator(hashCode: Int) {
        val navigatorIdx = navigators.indexOfFirst { it.id == hashCode }
        navigators.removeAt(navigatorIdx)
        currentNavigator = if (navigators.isNotEmpty()) navigators.last() else null
    }

    fun executeCommand(commands: Array<out SBCiceroneCommand>) {
        mainHandler.post {
            currentNavigator?.navigator?.applyCommands(commands) ?: pendingCommands.add(commands)
        }
    }

    data class SBCommandBufferItem(
        val id: Int,
        val navigator: SBNavigator,
    )
}