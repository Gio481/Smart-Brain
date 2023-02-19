package com.example.smartbrainguessmovies.presentation.my_smart_brain

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguessmovies.databinding.SbGuessMoviesChildViewBinding
import com.example.smartbrainnavigation.cicerone.constants.GUESS_MOVIES
import com.example.smartbrainnavigation.cicerone.navigator.SBAppNavigators
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get
import kotlin.coroutines.CoroutineContext

@SuppressLint("SetTextI18n")
class SBGuessMoviesChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding = SbGuessMoviesChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val navigator = get<SBAppNavigators.GuessCharacters>(SBAppNavigators.GuessCharacters::class.java, GUESS_MOVIES)

    private val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main

    init {


    }
}