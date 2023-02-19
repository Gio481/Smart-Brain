package com.example.smartbrainthemaze.presentation.my_smart_brain

import android.content.Context
import android.view.LayoutInflater
import com.example.smartbraincomponents.my_smart_brain.SBMySmartBrainBaseChildView
import com.example.smartbrainthemaze.databinding.SbTheMazeMySmartBrainChildViewBinding
import com.example.smartbrainthemaze.navigation.Navigator
import com.example.smartbrainthemaze.navigation.NavigatorImpl
import org.koin.java.KoinJavaComponent.get

class SBTheMazeMySmartBrainChildView(context: Context):SBMySmartBrainBaseChildView(context){

    private val binding = SbTheMazeMySmartBrainChildViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val navigator = get<Navigator>(NavigatorImpl::class.java)

    init {
        binding.root.setOnClickListener {
            navigator.navigateToMaze()
        }
    }

}