package com.example.smartbrainguesscharacterscommon.presentation.guess_character_list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbraincomponents.R
import com.example.smartbrainguesscharacterscommon.databinding.SbGuessCharacterCommonListItemBinding
import com.example.smartbrainguesscharacterscommon.domain.models.SBGuessCharacterListData

class SBGuessCharacterListAdapter : RecyclerView.Adapter<SBGuessCharacterListAdapter.ViewHolder>() {

    private val list = mutableListOf<SBGuessCharacterListData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SbGuessCharacterCommonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


    class ViewHolder(private val binding: SbGuessCharacterCommonListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: SBGuessCharacterListData) {
            with(binding.guessCharacterItemButton) {
                text = item.labelText
                backgroundTintList = ContextCompat.getColorStateList(binding.root.context, R.color.white)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<SBGuessCharacterListData>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}