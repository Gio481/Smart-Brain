package com.example.smartbrainintro.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.smartbrainintro.R
import com.example.smartbrainintro.databinding.SbFindSimilarPieceLayoutBinding


abstract class BaseOnBoardingFragment<VB : ViewBinding> : Fragment() {
    private var _binding: VB? = null
    protected val binding get() = _binding!!
    abstract val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachRoot: Boolean) -> VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class BlankFragment :BaseOnBoardingFragment<SbFindSimilarPieceLayoutBinding>(){
    override val bindingInflater: (inflater: LayoutInflater, container: ViewGroup?, attachRoot: Boolean) -> SbFindSimilarPieceLayoutBinding
        get() = SbFindSimilarPieceLayoutBinding::inflate
}

class BlankFragment2 : Fragment(R.layout.sb_the_maze_layout)

class BlankFragment3 : Fragment(R.layout.sb_guess_character_layout)
