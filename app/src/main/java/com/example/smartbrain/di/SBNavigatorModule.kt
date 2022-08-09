package com.example.smartbrain.di

import com.example.smartbrainnavigation.cicerone.SBCicerone
import com.example.smartbrainnavigation.cicerone.SBNavigationStrategy
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FEATURE
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FLOW
import com.example.smartbrainnavigation.cicerone.di.injectFlowNavigatorModule
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainnavigation.cicerone.flow.SBFlowNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainsplash.navigation.SBSplashNavigator
import com.example.smartbrainsplash.navigation.SBSplashNavigatorImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val sbNavigatorModule = module {
    single<SBNavigationStrategy<SBFeatureScreen>>(CICERONE_FEATURE) { SBFeatureNavigatorStrategy() }
    single<SBNavigationStrategy<SBFlowScreen>>(CICERONE_FLOW) { SBFlowNavigatorStrategy() }
    single { SBFeatureRouter() } bind SBBaseRouter::class
    single(CICERONE_FEATURE) { SBCicerone.create(customRouter = get<SBFeatureRouter>()) }
    single(CICERONE_FEATURE) { get<SBCicerone<SBFeatureRouter>>(CICERONE_FEATURE).getNavigatorHolder() }

    single<SBSplashNavigator> { SBSplashNavigatorImpl(router = get()) }
}