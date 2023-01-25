package com.example.smartbrainguesscharacterscommon.feature.multi_game.di

class SBGuessCharacterMultiGameFeatureComponentImpl : SBGuessCharacterMultiGameFeatureComponent {

    override fun featureModule() = SBGuessCharacterMultiGameFeatureModule(featureQualifier())
    override fun featureDestroy() = featureModule().destroy()
}