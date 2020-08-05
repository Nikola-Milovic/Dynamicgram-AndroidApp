package com.nikolam.feature_homefeed.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikolam.feature_homefeed.data.model.Story
import com.nikolam.feature_homefeed.ui.utils.bindings
import com.nikolam.feature_homefeed.R
import com.nikolam.feature_homefeed.databinding.ItemStoryBinding

class StoryAdapter(val stories : ArrayList<Story>) :
    RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {

        val data = stories[position]
        try {
            holder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount() : Int {
        return stories.size
    }


    inner class StoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var data: Story
        private val binding: ItemStoryBinding by bindings(view)

        fun bindData(data: Any) {
            if (data is Story) {
                this.data = data
                drawItemUI()
            }
        }

        private fun drawItemUI() {
            binding.apply {
                story = data
                executePendingBindings()
            }
        }

    }

}
