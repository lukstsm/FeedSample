package com.sample.reddit.feed

import android.util.Log
import androidx.lifecycle.ViewModel

class FeedViewModel : ViewModel() {

    fun onButtonTap() {
        Log.d("FeedViewModel", "button tapped.")
    }

}