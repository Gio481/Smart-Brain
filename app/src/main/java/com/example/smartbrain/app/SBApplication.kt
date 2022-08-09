package com.example.smartbrain.app

import android.app.Application
import com.example.smartbrain.di.sbInitialModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SBApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SBApplication)
            modules(sbInitialModules)
        }
    }
}