package com.example.smartbrainguesscharacters.presentation.guess_movie.movies_list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbraincomponents.R
import com.example.smartbrainguesscharacters.databinding.SbGuessMoviesGenreListItemBinding

class SBGuessMoviesGenreListAdapter :
    RecyclerView.Adapter<SBGuessMoviesGenreListAdapter.ViewHolder>() {

    private val genreList = mutableListOf<SBGuessMoviesGenreListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SbGuessMoviesGenreListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(genreList[position])
    }

    override fun getItemCount(): Int = genreList.size


    class ViewHolder(private val binding: SbGuessMoviesGenreListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(genre: SBGuessMoviesGenreListData) {
            with(binding) {
                moviesGenreButton.text = genre.movieGenre
                moviesGenreButton.backgroundTintList = ContextCompat.getColorStateList(root.context, R.color.white)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<SBGuessMoviesGenreListData>) {
        genreList.clear()
        genreList.addAll(list)
        notifyDataSetChanged()
    }
}