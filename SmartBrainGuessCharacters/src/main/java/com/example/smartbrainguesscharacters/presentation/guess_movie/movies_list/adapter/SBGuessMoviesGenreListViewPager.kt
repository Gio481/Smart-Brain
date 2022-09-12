package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.child.SBGuessMoviesListChildFragment
import java.util.ArrayList
import java.util.HashMap

class SBGuessMoviesGenreListViewPager(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var values: Map<Int, ArrayList<SBGuessMoviesGenreListData>> = HashMap()

    override fun getItemCount(): Int = values.size

    override fun createFragment(position: Int): Fragment {
        return SBGuessMoviesListChildFragment().apply {
            values[position]?.let { initData(it) }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(hashMap: Map<Int, ArrayList<SBGuessMoviesGenreListData>>) {
        values = HashMap()
        values = hashMap
        notifyDataSetChanged()
    }
}