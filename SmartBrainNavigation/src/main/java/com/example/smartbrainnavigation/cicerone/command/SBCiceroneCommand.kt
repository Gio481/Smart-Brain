package com.example.smartbrainnavigation.cicerone.command

import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen

interface SBCiceroneCommand
data class Add(val screen: SBBaseScreen) : SBCiceroneCommand
data class Replace(val screen: SBBaseScreen) : SBCiceroneCommand
class Pop : SBCiceroneCommand
class Clear : SBCiceroneCommand
class Back : SBCiceroneCommand
data class BackTo(val screen: SBBaseScreen?) : SBCiceroneCommand