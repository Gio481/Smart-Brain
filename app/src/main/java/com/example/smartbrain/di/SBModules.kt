package com.example.smartbrain.di

import com.example.smartbrain.view_provider.SBMySmartBrainViewProviderImpl
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigator
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigatorImpl
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainguesscharacters.navigation.SBGuessCharacterNavigator
import com.example.smartbrainguesscharacters.navigation.SBGuessCharacterNavigatorImpl
import com.example.smartbrainhome.navigation.SBHomeNavigator
import com.example.smartbrainhome.navigation.SBHomeNavigatorImpl
import com.example.smartbrainintro.navigation.SBIntroNavigator
import com.example.smartbrainintro.navigation.SBIntroNavigatorImpl
import com.example.smartbrainnavigation.cicerone.SBCicerone
import com.example.smartbrainnavigation.cicerone.base.SBBaseRouter
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FEATURE
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FLOW
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainnavigation.cicerone.flow.SBFlowNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterServiceImpl
import com.example.smartbrainsplash.navigation.SBSplashNavigator
import com.example.smartbrainsplash.navigation.SBSplashNavigatorImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


val sbNavigatorModule = module {
    singleOf(::SBFeatureRouter) { bind<SBBaseRouter>() }
    single<SBNavigatorStrategy<SBFeatureScreen>>(CICERONE_FEATURE) { SBFeatureNavigatorStrategy() }
    single<SBNavigatorStrategy<SBFlowScreen>>(CICERONE_FLOW) { SBFlowNavigatorStrategy() }
    single(CICERONE_FEATURE) { SBCicerone.create(customRouter = get<SBFeatureRouter>()) }
    single(CICERONE_FEATURE) { get<SBCicerone<SBFeatureRouter>>(CICERONE_FEATURE).getNavigatorHolder() }
    single<SBFlowRouterService> { SBFlowRouterServiceImpl(router = null) }

    singleOf(::SBSplashNavigatorImpl) { bind<SBSplashNavigator>() }
    singleOf(::SBIntroNavigatorImpl) { bind<SBIntroNavigator>() }
    singleOf(::SBAuthenticationNavigatorImpl) { bind<SBAuthenticationNavigator>() }
    singleOf(::SBHomeNavigatorImpl) { bind<SBHomeNavigator>() }
    singleOf(::SBGuessCharacterNavigatorImpl) { bind<SBGuessCharacterNavigator>() }
}

val viewProvidesModule = module {
    singleOf(::SBMySmartBrainViewProviderImpl) { bind<SBMySmartBrainViewProvider>() }
}
