package com.alaaeddinalbarghoth.simplelistapp.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alaaeddinalbarghoth.simplelistapp.data.local.FeedItem

@BindingAdapter("feedItems", "feedsAdapter")
fun RecyclerView.bindFeedItems(
    feedItems: List<FeedItem>?,
    feedsAdapter: FeedsAdapter?
) {
    if (feedItems != null && feedsAdapter != null) {
        feedsAdapter.submitList(feedItems)
        this@bindFeedItems.layoutManager =
            LinearLayoutManager(
                this@bindFeedItems.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        this@bindFeedItems.adapter = feedsAdapter
    }
}