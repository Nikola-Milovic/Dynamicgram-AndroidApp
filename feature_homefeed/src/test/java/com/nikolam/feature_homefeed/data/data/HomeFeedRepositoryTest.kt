package com.nikolam.feature_homefeed.data.data

import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.model.fakePosts
import com.nikolam.feature_homefeed.data.model.fakeStories
import org.junit.Test


class HomeFeedRepositoryTest {

    val fakeNetworkDataSource = FakeNetworkDataSource()
    val homeFeedRepository =
        ImplHomeFeedRepository(
            fakeNetworkDataSource
        )

    @Test
    fun `when requested stories, will return populated list of stories`() {
        val expectedData = fakeStories

        val actualData =  homeFeedRepository.fetchStories()

        assert(expectedData == actualData)
    }

    @Test
    fun `when requested posts, will return populated list of posts`() {
        val expectedData = fakePosts


        val actualData =  homeFeedRepository.fetchPosts()

        assert(expectedData == actualData)
    }



}
