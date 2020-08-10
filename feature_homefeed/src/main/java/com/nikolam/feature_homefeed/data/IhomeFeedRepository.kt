package com.nikolam.feature_homefeed.data

import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story

interface IhomeFeedRepository {
    fun fetchStories() : ArrayList<Story>
    fun fetchPosts() : ArrayList<Post>
}