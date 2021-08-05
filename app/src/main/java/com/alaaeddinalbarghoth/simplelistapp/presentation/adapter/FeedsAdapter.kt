package com.alaaeddinalbarghoth.simplelistapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.alaaeddinalbarghoth.simplelistapp.R
import com.alaaeddinalbarghoth.simplelistapp.data.local.FeedItem
import com.alaaeddinalbarghoth.simplelistapp.databinding.ItemFeedBinding

class FeedsAdapter :
    ListAdapter<FeedItem, FeedsAdapter.FeedsVH>(FeedsDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FeedsAdapter.FeedsVH =
        FeedsVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_feed,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FeedsVH, position: Int) {
        with(holder.itemFeedBinding) {
            this.feedItem = getItem(position)
        }
    }

    /** ViewHolder */
    inner class FeedsVH(val itemFeedBinding: ItemFeedBinding) :
        RecyclerView.ViewHolder(itemFeedBinding.root)
}