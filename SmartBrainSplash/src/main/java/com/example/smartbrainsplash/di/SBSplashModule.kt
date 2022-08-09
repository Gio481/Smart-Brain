package com.example.smartbrainsplash.di

import com.example.smartbrainsplash.presentation.main.vm.SBSplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sbSplashModule = module {
    viewModel {
        SBSplashViewModel()
    }
}