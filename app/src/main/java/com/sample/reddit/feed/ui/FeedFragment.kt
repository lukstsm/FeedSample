package com.sample.reddit.feed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
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

        val layoutManager = LinearLayoutManager(context)
        binding.feedRecyclerView.layoutManager = layoutManager
        binding.feedRecyclerView.adapter = adapter
        binding.feedRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), layoutManager.orientation).apply {
                setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.feed_divider)!!)
            }
        )
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