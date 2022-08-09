package com.example.smartbrainnavigation.cicerone.command

import com.example.smartbrainnavigation.cicerone.screen.SBScreen

interface SBCiceroneCommand
data class Add(val screen: SBScreen) : SBCiceroneCommand
data class Replace(val screen: SBScreen) : SBCiceroneCommand
class Pop : SBCiceroneCommand
class Clear : SBCiceroneCommand
class Back : SBCiceroneCommand
data class BackTo(val screen: SBScreen?) : SBCiceroneCommand