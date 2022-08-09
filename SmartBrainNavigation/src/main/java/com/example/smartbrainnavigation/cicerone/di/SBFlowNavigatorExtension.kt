package com.example.smartbrainnavigation.cicerone.di

import com.example.smartbrainnavigation.cicerone.SBCicerone
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import org.koin.core.module.Module
import org.koin.dsl.bind

fun Module.injectFlowNavigatorModule() {
    single { SBFlowRouter(featureRouter = get()) } bind SBBaseRouter::class
    single { SBCicerone.create(customRouter = get<SBFlowRouter>()) }
    single { get<SBCicerone<SBFlowRouter>>().getNavigatorHolder() }
}