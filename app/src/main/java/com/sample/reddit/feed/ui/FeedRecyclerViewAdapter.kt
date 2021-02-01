package com.sample.reddit.feed.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.reddit.R
import com.sample.reddit.databinding.FeedRowBinding
import com.sample.reddit.feed.domain.Post

class FeedRecyclerViewAdapter : RecyclerView.Adapter<FeedRowViewHolder>() {

    var onItemClickListener: ((Post) -> Unit)? = null

    var items: List<Post> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedRowViewHolder {
        val view = FeedRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedRowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedRowViewHolder, position: Int) {
        holder.binding.author.text = holder.itemView.context.getString(R.string.post_author, items[position].author)
        holder.binding.title.text = items[position].title
        holder.itemView.setOnClickListener { onItemClickListener?.invoke(items[position]) }
    }

}