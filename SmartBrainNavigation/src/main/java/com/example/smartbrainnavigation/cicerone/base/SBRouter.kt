package com.example.smartbrainnavigation.cicerone.base

import com.example.smartbrainnavigation.cicerone.command.*

open class SBRouter : SBBaseRouter() {

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

    open fun finishFlow() {}
}