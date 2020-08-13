package com.nikolam.feature_explore.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.nikolam.core.ui.base.DatabindingFragment
import com.nikolam.core.ui.extensions.coreComponent
import com.nikolam.feature_explore.R.*
import com.nikolam.feature_explore.data.model.Post
import com.nikolam.feature_explore.databinding.ExploreFragmentBinding
import com.nikolam.feature_explore.di.DaggerExploreComponent
import com.nikolam.feature_explore.ui.adapters.ExploreAdapter
import com.nikolam.feature_explore.di.ExploreModule
import javax.inject.Inject

class ExploreFragment : DatabindingFragment() {

    @Inject
    lateinit var exploreViewModel: ExploreViewModel

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
                GridLayoutManager(context, 3)

            adapter = ExploreAdapter()

            gridExploreRecycleView.apply {
                layoutManager = layoutMana
                //setHasFixedSize(true)
            }

            this.exploreAdapter = adapter
            viewModel = viewModel
            lifecycleOwner = this@ExploreFragment

//            adapter.addPostList(arrayListOf(Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
//                Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"), Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png"),
//                Post("https://homepages.cae.wisc.edu/~ece533/images/cat.png")))
        }.root
    }

    private fun observeData() {
        viewModel.postListLiveData.observe(viewLifecycleOwner, Observer {
            adapter.addPostList(it)
        })
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        initDependencyInjection()
    }

    private fun initDependencyInjection() =
        DaggerExploreComponent
            .builder()
            .coreComponent(coreComponent())
            .exploreModule(ExploreModule(this))
            .build()
            .inject(this)
}
