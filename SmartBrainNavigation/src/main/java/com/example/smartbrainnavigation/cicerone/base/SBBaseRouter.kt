package com.example.smartbrainnavigation.cicerone.base

import com.example.smartbrainnavigation.cicerone.SBCommandBuffer
import com.example.smartbrainnavigation.cicerone.command.*

abstract class SBBaseRouter {

    internal val commandBuffer = SBCommandBuffer()

    protected fun executeCommands(vararg command: SBCiceroneCommand) {
        commandBuffer.executeCommand(command)
    }
    protected fun executeAdd(screen: SBBaseScreen) {
        executeCommands(Add(screen))
    }

    protected fun executeReplace(screen: SBBaseScreen) {
        executeCommands(Replace(screen))
    }

    protected fun executePop() {
        executeCommands(Pop())
    }

    protected fun executeClear() {
        executeCommands(Clear())
    }

    fun backTo(screen: SBBaseScreen) {
        executeCommands(BackTo(screen))
    }

    fun back() {
        executeCommands(Back())
    }

    abstract fun finishFlow()
}