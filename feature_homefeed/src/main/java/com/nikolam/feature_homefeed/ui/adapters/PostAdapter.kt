package com.nikolam.feature_homefeed.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.core.ui.utils.bindings
import com.nikolam.feature_homefeed.R
import com.nikolam.feature_homefeed.databinding.ItemPostBinding

class PostAdapter() :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts : ArrayList<Post> = arrayListOf()

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val data = posts[position]
        try {
            holder.bindData(data)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun addPostList(_posts : ArrayList<Post>) {
        posts.clear()
        posts.addAll(_posts)
        this.notifyDataSetChanged()
    }

    override fun getItemCount() : Int {
        return posts.size
    }


    inner class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var data: Post
        private val binding: ItemPostBinding by bindings(view)

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
