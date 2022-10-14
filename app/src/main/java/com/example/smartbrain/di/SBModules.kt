package com.example.smartbrain.di

import com.example.smartbrain.view_provider.SBMySmartBrainViewProviderImpl
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigator
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigatorImpl
import com.example.smartbraincomponents.coroutine.SBDispatcherProvider
import com.example.smartbraincomponents.coroutine.SBDispatcherProviderImpl
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbraindatabase.db.provideGuessMoviesDao
import com.example.smartbraindatabase.db.provideSBDatabase
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigator
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigatorImpl
import com.example.smartbrainhome.navigation.SBHomeNavigator
import com.example.smartbrainhome.navigation.SBHomeNavigatorImpl
import com.example.smartbrainintro.navigation.SBIntroNavigator
import com.example.smartbrainintro.navigation.SBIntroNavigatorImpl
import com.example.smartbrainnavigation.cicerone.SBCicerone
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
    single<SBNavigatorStrategy<SBFeatureScreen>>(CICERONE_FEATURE) { SBFeatureNavigatorStrategy() }
    single<SBNavigatorStrategy<SBFlowScreen>>(CICERONE_FLOW) { SBFlowNavigatorStrategy() }
    single { SBFeatureRouter() }
    single(CICERONE_FEATURE) { SBCicerone.create(customRouter = get<SBFeatureRouter>()) }
    single(CICERONE_FEATURE) { get<SBCicerone<SBFeatureRouter>>(CICERONE_FEATURE).getNavigatorHolder() }
    single<SBFlowRouterService> { SBFlowRouterServiceImpl(router = null) }

    singleOf(::SBSplashNavigatorImpl) { bind<SBSplashNavigator>() }
    singleOf(::SBIntroNavigatorImpl) { bind<SBIntroNavigator>() }
    singleOf(::SBAuthenticationNavigatorImpl) { bind<SBAuthenticationNavigator>() }
    singleOf(::SBHomeNavigatorImpl) { bind<SBHomeNavigator>() }
    singleOf(::SBGuessMoviesNavigatorImpl) { bind<SBGuessMoviesNavigator>() }
}

val viewProvidesModule = module {
    singleOf(::SBMySmartBrainViewProviderImpl) { bind<SBMySmartBrainViewProvider>() }
}

val databaseModule = module {
    single { provideSBDatabase(context = get()) }
    single { provideGuessMoviesDao(db = get()) }
}

val dispatcherProviderModule = module {
    single<SBDispatcherProvider> { SBDispatcherProviderImpl() }
}
