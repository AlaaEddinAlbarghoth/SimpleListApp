package com.alaaeddinalbarghoth.simplelistapp.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.alaaeddinalbarghoth.simplelistapp.data.local.FeedItem

class FeedsDiffUtil : DiffUtil.ItemCallback<FeedItem>() {

    override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean =
        oldItem.title === newItem.title

    override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean =
        oldItem == newItem
}