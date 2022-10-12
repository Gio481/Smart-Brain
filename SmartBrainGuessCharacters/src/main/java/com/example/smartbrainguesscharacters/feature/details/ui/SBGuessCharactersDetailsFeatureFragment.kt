package com.example.smartbrainguesscharacters.feature.details.ui

import android.os.Bundle
import com.example.smartbraincomponents.base.SBBaseFeatureFragment
import com.example.smartbrainguesscharacters.R
import com.example.smartbrainguesscharacters.feature.details.di.SBDetailsFeatureComponentImpl
import com.example.smartbrainguesscharacters.feature.details.vm.SBGuessCharactersDetailsFeatureVm
import kotlin.reflect.KClass

class SBGuessCharactersDetailsFeatureFragment : SBBaseFeatureFragment<SBGuessCharactersDetailsFeatureVm>() {

    override fun getViewModelClass(): KClass<SBGuessCharactersDetailsFeatureVm> =
        SBGuessCharactersDetailsFeatureVm::class

    override fun getTitleResId(): Int = R.string.details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onDestroyComponents() {
        SBDetailsFeatureComponentImpl().featureDestroy()
    }
}