package com.nikolam.feature_homefeed.data.data

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story

interface INetworkDataSource {
    fun fetchStories() : ArrayList<Story>
    fun fetchPosts() : ArrayList<Post>
}
