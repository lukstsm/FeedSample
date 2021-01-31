package com.sample.reddit.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.sample.reddit.R
import org.koin.android.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            viewModel.onButtonTap()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}