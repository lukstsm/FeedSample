package com.sample.reddit.feed.domain

import com.sample.reddit.feed.data.Feed as FeedData

class FeedMapper {

    fun mapToDomain(feed: FeedData): Feed {
        return Feed(
            feed.data.children.map {
                Post(it.data.title, it.data.selftext, it.data.author, it.data.url)
            }
        )
    }

}