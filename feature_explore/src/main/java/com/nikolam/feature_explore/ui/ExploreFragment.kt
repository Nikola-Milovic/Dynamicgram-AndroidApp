package com.nikolam.feature_explore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.nikolam.core.ui.base.DatabindingFragment
import com.nikolam.feature_explore.ExploreAdapter
import com.nikolam.feature_explore.R.*
import com.nikolam.feature_explore.data.model.Post
import com.nikolam.feature_explore.databinding.ExploreFragmentBinding

class ExploreFragment : DatabindingFragment() {

    lateinit var binding: ExploreFragmentBinding

    private lateinit var viewModel: ExploreViewModel
    private lateinit var adapter: ExploreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        feedViewModel = ViewModelProviders.of(this, modelFactory)[HomeFeedViewModel::class.java]
//           // ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)

        observeData()

        return binding<ExploreFragmentBinding>(inflater, layout.explore_fragment, container).apply {

            val layoutMana =
                GridLayoutManager(context, 4)

            adapter = ExploreAdapter()

            gridExploreRecycleView.apply {
                layoutManager = layoutMana
            }
            this.exploreAdapter = adapter
            viewModel = viewModel
            lifecycleOwner = this@ExploreFragment

            adapter.addPostList(arrayListOf(Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png")))
        }.root
    }

    private fun observeData() {
//        viewModel..observe(viewLifecycleOwner, Observer {
//            postAdapter.addPostList(it)
//        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ExploreViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
