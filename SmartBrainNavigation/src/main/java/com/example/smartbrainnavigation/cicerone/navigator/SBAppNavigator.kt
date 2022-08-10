package com.example.smartbrainnavigation.cicerone.navigator

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.smartbrainnavigation.cicerone.base.SBBaseScreen
import com.example.smartbrainnavigation.cicerone.command.*
import com.example.smartbrainnavigation.cicerone.screen.SBScreen

abstract class SBAppNavigator<T : SBBaseScreen>(
    protected val activity: FragmentActivity,
    protected val containerId: Int,
    protected val fragmentManager: FragmentManager = activity.supportFragmentManager,
) : SBNavigator {

    protected val localStackCopy = mutableListOf<String>()

    override fun applyCommands(commands: Array<out SBCiceroneCommand>) {
        fragmentManager.executePendingTransactions()
        copyStackToLocal()
        for (command in commands) {
            try {
                applyCommand(command)
            } catch (e: RuntimeException) {
                errorOnApplyCommand(command, e)
            }
        }

    }

    private fun copyStackToLocal() {
        localStackCopy.clear()
        (0 until fragmentManager.backStackEntryCount).forEach { i ->
            localStackCopy.add(fragmentManager.getBackStackEntryAt(i).name ?: "")
        }
    }

    protected open fun applyCommand(command: SBCiceroneCommand) {
        when (command) {
            is Add -> add(command)
            is Replace -> replace(command)
            is Pop -> pop()
            is Clear -> clear()
            is BackTo -> backTo(command)
            is Back -> back()
        }
    }

    protected open fun add(command: Add){
        commitNewFragmentScreen(
            command.screen as SBBaseScreen,
            command,
            addToBackStack = true,
            shouldReplace = false
        )
    }
    protected  open fun replace(command: Replace){
        commitNewFragmentScreen(
            command.screen as SBBaseScreen,
            command,
            addToBackStack = true,
            shouldReplace = true
        )
    }
    private fun pop(){
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
        }
    }
    private fun clear(){
        if (localStackCopy.isNotEmpty()) {
            (0..fragmentManager.backStackEntryCount).forEach { _ ->
                fragmentManager.popBackStack()
                localStackCopy.removeAt(localStackCopy.lastIndex)
            }
        }
    }
    protected open fun back(){
        if (localStackCopy.isNotEmpty()) {
            fragmentManager.popBackStack()
            localStackCopy.removeAt(localStackCopy.lastIndex)
        } else {
            activityBack()
        }
    }

    protected open fun backTo(command: BackTo){
        if (command.screen == null) {
            backToRoot()
        } else {
            val screenKey = command.screen.screenKey
            val index = localStackCopy.indexOfFirst { it == screenKey }
            if (index != -1) {
                val forRemove = localStackCopy.subList(index, localStackCopy.size)
                fragmentManager.popBackStack(forRemove.first().toString(), 0)
                forRemove.clear()
            } else {
                backToUnexisting(command.screen)
            }
        }
    }

    private fun backToRoot() {
        localStackCopy.clear()
        fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    protected open fun backToUnexisting(screen: SBScreen) {
        backToRoot()
    }

    protected open fun activityBack() {
        activity.finish()
    }

    private fun commitNewFragmentScreen(
        screen: SBBaseScreen,
        command: SBCiceroneCommand,
        addToBackStack:Boolean,
        shouldReplace:Boolean
    ){
        val fragment = screen.getFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.setReorderingAllowed(true)
        setupFragmentTransaction(
            screen,
            transaction,
            fragmentManager.findFragmentById(containerId),
            fragment
        )
        if (shouldReplace) {
            transaction.replace(containerId, fragment, screen.screenKey)
        } else {
            transaction.add(containerId, fragment, screen.screenKey)
        }
        if (addToBackStack) {
            transaction.addToBackStack(screen.screenKey)
            localStackCopy.add(screen.screenKey)
        }
        transaction.commit()
    }

    protected open fun setupFragmentTransaction(
        screen: SBBaseScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
    }

    protected open fun errorOnApplyCommand(
        command: SBCiceroneCommand,
        error: RuntimeException
    ) {
        throw error
    }
}