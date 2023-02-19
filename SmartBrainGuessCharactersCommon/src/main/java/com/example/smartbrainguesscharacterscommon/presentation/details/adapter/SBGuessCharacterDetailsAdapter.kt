package com.example.smartbrainguesscharacterscommon.presentation.details.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbraincomponents.R
import com.example.smartbrainguesscharacterscommon.databinding.SbDetailsGuessMoviesLevelItemBinding

class SBGuessCharacterDetailsAdapter(private val level: Int) :
    RecyclerView.Adapter<SBGuessCharacterDetailsAdapter.ViewHolder>() {

    private val itemList = mutableListOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SbDetailsGuessMoviesLevelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(itemList[position], level, itemList.size)
    }

    override fun getItemCount(): Int = itemList.size

    class ViewHolder(private val binding: SbDetailsGuessMoviesLevelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Int, level: Int, fullLevel:Int) {
            with(binding) {
                stickView.isVisible = adapterPosition!=fullLevel-1
                levelTextView.text = item.toString()
                when {
                    adapterPosition + 1 < level -> {
                        levelTextView.backgroundTintList =
                            androidx.core.content.ContextCompat.getColorStateList(binding.root.context,
                                R.color.green)
                    }
                    adapterPosition + 1 == level -> {
                        levelTextView.backgroundTintList =
                            androidx.core.content.ContextCompat.getColorStateList(binding.root.context,
                                R.color.blue)
                    }
                    else -> {
                        levelTextView.backgroundTintList =
                            androidx.core.content.ContextCompat.getColorStateList(binding.root.context,
                                R.color.red)
                    }
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Int>) {
        itemList.clear()
        itemList.addAll(list)
        notifyDataSetChanged()
    }
}