package com.example.smartbrainnavigation.cicerone.di

import com.example.smartbrainnavigation.cicerone.SBCicerone
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.flow.SBFlowRouter
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterServiceImpl
import org.koin.core.module.Module
import org.koin.core.qualifier.StringQualifier
import org.koin.dsl.bind

fun Module.injectFlowNavigatorModule(featureQualifier: StringQualifier) {
    single(featureQualifier) { SBFlowRouter(featureRouter = get()) }
    single(featureQualifier) { SBCicerone.create(customRouter = get<SBFlowRouter>(featureQualifier)) }
    single(featureQualifier) { get<SBCicerone<SBFlowRouter>>(featureQualifier).getNavigatorHolder() }
    single<SBFlowRouterService>(featureQualifier) { SBFlowRouterServiceImpl(router = get(featureQualifier)) }
}