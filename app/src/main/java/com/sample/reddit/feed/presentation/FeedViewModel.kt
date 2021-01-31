package com.sample.reddit.feed.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {

    val items = MutableLiveData<List<String>>()

    init {
        val list = mutableListOf<String>()

        for (i in 0..10) {
            list.add("item $i")
        }

        items.value = list
    }

    fun onButtonTap() {
        Log.d("FeedViewModel", "button tapped.")
    }

}