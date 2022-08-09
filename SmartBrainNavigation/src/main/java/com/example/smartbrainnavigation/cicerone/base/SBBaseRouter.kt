package com.example.smartbrainnavigation.cicerone.base

import com.example.smartbrainnavigation.cicerone.SBCommandBuffer
import com.example.smartbrainnavigation.cicerone.command.SBCiceroneCommand

abstract class SBBaseRouter {
    internal val commandBuffer = SBCommandBuffer()

    protected fun executeCommands(vararg command: SBCiceroneCommand){
        commandBuffer.executeCommand(command)
    }
}