package com.sample.reddit.feed.data

data class Feed(val data: FeedData)

data class FeedData(val children: List<FeedItem>)

data class FeedItem(val data: FeedItemData)

data class FeedItemData(val title: String, val selftext: String, val author: String, val url: String)