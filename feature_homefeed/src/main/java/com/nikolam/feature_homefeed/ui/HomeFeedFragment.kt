package com.nikolam.feature_homefeed.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.nikolam.feature_homefeed.R
import kotlinx.android.synthetic.main.home_feed_fragment.*

class HomeFeedFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFeedFragment()
    }

    private lateinit var viewModel: HomeFeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.home_feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messages_button.setOnClickListener {

            findNavController().navigate(HomeFeedFragmentDirections.actionHomeFeedToMessagesFragment2())

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}