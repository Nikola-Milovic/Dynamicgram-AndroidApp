package com.nikolam.feature_homefeed.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.nikolam.feature_homefeed.R
import com.nikolam.feature_homefeed.R.*
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
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
//
    view.findViewById<Button>(R.id.messages_button).setOnClickListener {

          val directions = HomeFeedFragmentDirections.actionHomeFeedFragmentToMessagesFragment()
           findNavController().navigate(directions)

        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeFeedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}