package com.nikolam.feature_homefeed.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nikolam.feature_homefeed.R
import com.nikolam.feature_homefeed.data.model.Story


class HeaderAdapter(val context: Context, val stories: ArrayList<Story>) :
    RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_feed_header_item, parent, false)
        return HeaderViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        // Create layout manager with initial prefetch item count

        val adapter = StoryAdapter(stories)
        val layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        (holder.view as RecyclerView).apply{
            this.layoutManager = layoutManager
            this.adapter = adapter
        }

    }

    override fun getItemCount(): Int {
        return 1
    }


    inner class HeaderViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }
}
