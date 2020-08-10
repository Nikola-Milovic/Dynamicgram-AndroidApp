package com.nikolam.feature_homefeed.data.data

import com.nikolam.feature_homefeed.data.IhomeFeedRepository
import com.nikolam.feature_homefeed.data.model.Post
import com.nikolam.feature_homefeed.data.model.Story
import com.nikolam.feature_homefeed.data.model.fakePosts
import com.nikolam.feature_homefeed.data.model.fakeStories

class FakeHomeFeedRepsitory : IhomeFeedRepository{
    override fun fetchStories(): ArrayList<Story> {
        return fakeStories
    }

    override fun fetchPosts(): ArrayList<Post> {
        return fakePosts
    }

}
