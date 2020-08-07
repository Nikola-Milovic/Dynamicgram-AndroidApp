package com.nikolam.feature_homefeed.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikolam.feature_homefeed.R
import com.nikolam.core.ui.base.DatabindingFragment
import com.nikolam.core.ui.extensions.coreComponent
import com.nikolam.feature_homefeed.databinding.HomeFeedFragmentBinding
import com.nikolam.feature_homefeed.di.DaggerHomeFeedComponent
import com.nikolam.feature_homefeed.di.HomeFeedFragmentModule
import com.nikolam.feature_homefeed.ui.adapters.HeaderAdapter
import com.nikolam.feature_homefeed.ui.adapters.PostAdapter
import javax.inject.Inject

class HomeFeedFragment : DatabindingFragment() {

   // private lateinit var feedViewModel: HomeFeedViewModel


    @Inject
    lateinit var homefeedViewModel: HomeFeedViewModel

    lateinit var binding : HomeFeedFragmentBinding

    lateinit var postAdapter: PostAdapter
    lateinit var headerAdapter: HeaderAdapter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDependencyInjection()
    }

    private fun initDependencyInjection() =
        DaggerHomeFeedComponent
            .builder()
            .coreComponent(coreComponent())
            .homeFeedFragmentModule(HomeFeedFragmentModule(this))
            .build()
            .inject(this)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        feedViewModel = ViewModelProviders.of(this, modelFactory)[HomeFeedViewModel::class.java]
//           // ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)

        observeData()

        return binding<HomeFeedFragmentBinding>(inflater, R.layout.home_feed_fragment, container).apply {

            val layoutMana=
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            postAdapter = PostAdapter()
            headerAdapter = HeaderAdapter(requireContext(), homefeedViewModel.stories)
            val concatAdapter= ConcatAdapter(headerAdapter, postAdapter)
            recyclerViews.apply{
                layoutManager = layoutMana
            }
            this.concatAdapter = concatAdapter
            viewModel = viewModel
            lifecycleOwner = this@HomeFeedFragment

        }.root
    }


    private fun observeData(){
        homefeedViewModel._postListLiveData.observe(viewLifecycleOwner, Observer {
            postAdapter.addPostList(it)
        })
    }

}
