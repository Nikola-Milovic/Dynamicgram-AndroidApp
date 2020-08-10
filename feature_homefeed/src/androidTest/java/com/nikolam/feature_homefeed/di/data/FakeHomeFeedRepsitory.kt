package com.nikolam.feature_homefeed.di.data

import com.nikolam.feature_homefeed.data.IhomeFeedRepository
import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story

class FakeHomeFeedRepsitory : IhomeFeedRepository{
    override fun fetchStories(): ArrayList<Story> {
        TODO("Not yet implemented")
    }

    override fun fetchPosts(): ArrayList<Post> {
        TODO("Not yet implemented")
    }

}
