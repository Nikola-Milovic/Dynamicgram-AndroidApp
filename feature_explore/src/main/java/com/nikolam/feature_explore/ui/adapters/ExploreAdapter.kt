package com.nikolam.feature_explore.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikolam.core.ui.utils.bindings
import com.nikolam.feature_explore.R
import com.nikolam.feature_explore.data.model.Post
import com.nikolam.feature_explore.databinding.ExplorePostItemBinding
import timber.log.Timber

class ExploreAdapter() :
    RecyclerView.Adapter<ExploreAdapter.PostViewHolder>() {

    private var posts: ArrayList<Post> = arrayListOf()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.explore_post_item, parent, false)
        return PostViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = posts[position]
        Timber.d("bind")
        try {
            holder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addPostList(_posts: ArrayList<Post>) {
        posts.clear()
        posts.addAll(_posts)
        Timber.d("got data")
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        Timber.d(posts.size.toString())
        return posts.size
    }

    inner class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var data: Post
        private val binding: ExplorePostItemBinding by bindings(view)

        fun bindData(data: Any) {
            if (data is Post) {
                this.data = data
                drawItemUI()
            }
        }

        private fun drawItemUI() {
            binding.apply {
                post = data
                executePendingBindings()
            }
        }
    }
}
