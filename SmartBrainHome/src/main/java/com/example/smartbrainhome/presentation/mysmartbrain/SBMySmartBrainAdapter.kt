package com.example.smartbrainhome.presentation.mysmartbrain

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smartbraincomponents.view_provider.SBViewProvider

class SBMySmartBrainAdapter:RecyclerView.Adapter<SBMySmartBrainAdapter.ViewHolder>() {

    val viewHolderList : LinkedHashSet<ViewHolder> = LinkedHashSet()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(view:SBViewProvider):RecyclerView.ViewHolder(view as View)
}