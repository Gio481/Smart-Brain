package com.example.smartbrainnavigation.cicerone

import android.os.Handler
import android.os.Looper
import com.example.smartbrainnavigation.cicerone.command.SBCiceroneCommand
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigator
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorHolder

internal class SBCommandBuffer : SBNavigatorHolder {
    private var navigator: SBNavigator? = null
    private val pendingCommands = mutableListOf<Array<out SBCiceroneCommand>>()
    private val mainHandler = Handler(Looper.getMainLooper())

    override fun setNavigator(navigator: SBNavigator) {
        this.navigator = navigator
        pendingCommands.forEach { navigator.applyCommands(it) }
        pendingCommands.clear()
    }

    override fun removeNavigator() {
        navigator = null
    }

    fun executeCommand(commands: Array<out SBCiceroneCommand>) {
        mainHandler.post {
            navigator?.applyCommands(commands) ?: pendingCommands.add(commands)
        }
    }
}