package com.sample.reddit.feed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.reddit.databinding.FeedRowBinding

class FeedRecyclerViewAdapter : RecyclerView.Adapter<FeedRowViewHolder>() {

    var items: List<String> = emptyList()

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRowViewHolder {
        val view = FeedRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedRowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedRowViewHolder, position: Int) {
        holder.binding.title.text = items[position]
    }

}