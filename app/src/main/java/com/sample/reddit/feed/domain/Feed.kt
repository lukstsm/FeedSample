package com.sample.reddit.feed.domain

data class Feed(val posts: List<Post>)

data class Post(val title: String, val text: String, val url: String)