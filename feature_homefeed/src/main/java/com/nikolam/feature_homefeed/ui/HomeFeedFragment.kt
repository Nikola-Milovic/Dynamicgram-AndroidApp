package com.nikolam.feature_homefeed.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikolam.feature_homefeed.R
import com.nikolam.feature_homefeed.base.DatabindingFragment
import com.nikolam.feature_homefeed.databinding.HomeFeedFragmentBinding
import com.nikolam.feature_homefeed.ui.adapters.HeaderAdapter
import com.nikolam.feature_homefeed.ui.adapters.PostAdapter

class HomeFeedFragment : DatabindingFragment() {

    private lateinit var feedViewModel: HomeFeedViewModel

    lateinit var binding : HomeFeedFragmentBinding

    lateinit var postAdapter: PostAdapter
    lateinit var headerAdapter: HeaderAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        feedViewModel =
            ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)

        observeData()

        return binding<HomeFeedFragmentBinding>(inflater, R.layout.home_feed_fragment, container).apply {

            val layoutMana=
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            postAdapter = PostAdapter()
            headerAdapter = HeaderAdapter(requireContext(), feedViewModel.stories)
            val concatAdapter= ConcatAdapter(headerAdapter, postAdapter)
            recyclerViews.apply{
                layoutManager = layoutMana
            }
            this.concatAdapter = concatAdapter
            viewModel = feedViewModel
            lifecycleOwner = this@HomeFeedFragment

        }.root
    }


    private fun observeData(){
        feedViewModel._postListLiveData.observe(viewLifecycleOwner, Observer {
            postAdapter.addPostList(it)
        })
    }

}
