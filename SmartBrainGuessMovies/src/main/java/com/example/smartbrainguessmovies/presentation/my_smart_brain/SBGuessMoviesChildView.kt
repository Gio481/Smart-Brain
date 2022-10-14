package com.example.smartbrainguessmovies.presentation.my_smart_brain

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainguessmovies.databinding.SbGuessMoviesChildViewBinding
import com.example.smartbrainguessmovies.domain.usecase.SBGuessMoviesResponseUseCaseImpl
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigator
import com.example.smartbrainguessmovies.navigation.SBGuessMoviesNavigatorImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get
import org.koin.java.KoinJavaComponent.inject
import kotlin.coroutines.CoroutineContext

@SuppressLint("SetTextI18n")
class SBGuessMoviesChildView(context: Context) : SBMySmartBrainBaseChildView(context) {

    private val binding =
        SbGuessMoviesChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val navigator = get<SBGuessMoviesNavigator>(SBGuessMoviesNavigatorImpl::class.java)
    private val coroutineContext: CoroutineContext = SupervisorJob() + Dispatchers.Main
    private val useCase by inject<SBGuessMoviesResponseUseCaseImpl>(SBGuessMoviesResponseUseCaseImpl::class.java)

    init {
        CoroutineScope(coroutineContext).launch {
            if (useCase.getAllGuessMovies().isNotEmpty()) {
                binding.guessMoviesEmptyImageView.isVisible = false
                binding.levelTextView.text = "ტური ${useCase.getAllGuessMovies()[0].level}"
                binding.root.setOnClickListener {
                    navigator.navigateToDetails()
                }
            } else {
                binding.root.setOnClickListener {
                    navigator.navigateToStartGame()
                }
            }
        }

    }
}