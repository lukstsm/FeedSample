package com.sample.reddit.feed.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.reddit.R
import com.sample.reddit.core.ui.launchChromeTab
import com.sample.reddit.databinding.FeedFragmentBinding
import com.sample.reddit.feed.domain.Feed
import com.sample.reddit.feed.domain.Post
import com.sample.reddit.feed.presentation.FeedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class FeedFragment : Fragment() {

    private val viewModel: FeedViewModel by viewModel()
    private val adapter = FeedRecyclerViewAdapter()

    private lateinit var binding: FeedFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FeedFragmentBinding.inflate(inflater, container, false)

        binding.feedRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.feedRecyclerView.adapter = adapter
        adapter.onItemClickListener = this::onItemClicked

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            viewModel.onButtonTap()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        viewModel.feed.observe(viewLifecycleOwner, ::onState)
    }

    private fun onState(feed: Feed) {
        adapter.items = feed.posts
    }

    private fun onItemClicked(post: Post) {
        requireContext().launchChromeTab(post.url)
    }
}