package com.sample.reddit.feed.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface FeedApi {
    @GET("r/{subredit}/hot.json")
    fun getFeed(@Path("subredit") subredit: String): Observable<Feed>
}