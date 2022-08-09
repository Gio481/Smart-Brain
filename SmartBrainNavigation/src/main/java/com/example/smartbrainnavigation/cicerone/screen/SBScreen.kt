package com.example.smartbrainnavigation.cicerone.screen

interface SBScreen {
    val screenKey: String get() = this::class.java.name
}