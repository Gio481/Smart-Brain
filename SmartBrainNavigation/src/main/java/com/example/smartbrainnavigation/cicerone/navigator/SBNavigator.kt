package com.example.smartbrainnavigation.cicerone.navigator

import com.example.smartbrainnavigation.cicerone.command.SBCiceroneCommand

interface SBNavigator {
    fun applyCommands(commands: Array<out SBCiceroneCommand>)
}