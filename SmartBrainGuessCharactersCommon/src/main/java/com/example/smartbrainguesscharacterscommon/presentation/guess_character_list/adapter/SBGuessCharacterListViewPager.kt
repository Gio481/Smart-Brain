package com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smartbrainguesscharacterscommon.domain.models.SBGuessCharacterListData
import com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.child.SBGuessCharacterListChildFragment
import java.util.ArrayList
import java.util.HashMap

class SBGuessCharacterListViewPager(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var values: Map<Int, ArrayList<SBGuessCharacterListData>> = HashMap()

    override fun getItemCount(): Int = values.size

    override fun createFragment(position: Int): Fragment {
        return SBGuessCharacterListChildFragment().apply {
            values[position]?.let { initData(it) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(hashMap: Map<Int, ArrayList<SBGuessCharacterListData>>) {
        values = HashMap()
        values = hashMap
        notifyDataSetChanged()
    }
}