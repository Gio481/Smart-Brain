package com.example.smartbrain.di

import com.example.smartbrain.view_provider.SBMySmartBrainViewProviderImpl
import com.example.smartbrainauthentication.navigation.SBAuthenticationNavigatorImpl
import com.example.smartbraincomponents.coroutine.SBDispatcherProvider
import com.example.smartbraincomponents.coroutine.SBDispatcherProviderImpl
import com.example.smartbraincomponents.view_provider.SBMySmartBrainViewProvider
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigatorImpl
import com.example.smartbrainhome.navigation.SBHomeNavigatorImpl
import com.example.smartbrainintro.navigation.SBIntroNavigatorImpl
import com.example.smartbrainnavigation.cicerone.SBCicerone
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FEATURE
import com.example.smartbrainnavigation.cicerone.constants.CICERONE_FLOW
import com.example.smartbrainnavigation.cicerone.constants.GUESS_MOVIES
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureRouter
import com.example.smartbrainnavigation.cicerone.feature.SBFeatureScreen
import com.example.smartbrainnavigation.cicerone.flow.SBFlowNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.flow.SBFlowScreen
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import com.example.smartbrainnavigation.cicerone.navigator.SBNavigatorStrategy
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterService
import com.example.smartbrainnavigation.cicerone.service.SBFlowRouterServiceImpl
import com.example.smartbrainsplash.navigation.SBSplashNavigatorImpl
import com.google.firebase.firestore.FirebaseFirestore
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

    single<SBAppNavigators.Splash> { SBSplashNavigatorImpl(router = get()) }
    single<SBAppNavigators.Intro> { SBIntroNavigatorImpl(router = get()) }
    single<SBAppNavigators.Authentication> { SBAuthenticationNavigatorImpl(router = get()) }
    single<SBAppNavigators.Home> { SBHomeNavigatorImpl(router = get()) }
    single<SBAppNavigators.GuessCharacters>(GUESS_MOVIES) { SBGuessMoviesNavigatorImpl(router = get()) }


}

val viewProvidesModule = module {
    singleOf(::SBMySmartBrainViewProviderImpl) { bind<SBMySmartBrainViewProvider>() }
}

val dispatcherProviderModule = module {
    single<SBDispatcherProvider> { SBDispatcherProviderImpl() }
}

val fireBaseModule = module {
    single { FirebaseFirestore.getInstance() }
}
