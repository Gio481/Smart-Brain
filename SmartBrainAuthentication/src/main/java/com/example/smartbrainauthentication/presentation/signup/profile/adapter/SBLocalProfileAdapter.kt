package com.example.smartbrainauthentication.presentation.signup.profile.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbrainauthentication.databinding.SbAuthenticationLocalProfileItemBinding

class SBLocalProfileAdapter : RecyclerView.Adapter<SBLocalProfileAdapter.ViewHolder>() {

    private val profileImageList = mutableListOf<SBLocalProfileData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SbAuthenticationLocalProfileItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewHolder = ViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(profileImageList[position])
    }

    override fun getItemCount(): Int = profileImageList.size

    class ViewHolder(private val binding: SbAuthenticationLocalProfileItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: SBLocalProfileData) {
            binding.profileImageView.setBackgroundResource(item.localProfile)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<SBLocalProfileData>) {
        profileImageList.clear()
        profileImageList.addAll(list)
        notifyDataSetChanged()
    }
}