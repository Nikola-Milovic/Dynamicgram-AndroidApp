package com.nikolam.feature_homefeed

import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.network.FakeNetworkDataSource
import org.junit.Test


class HomeFeedRepositoryTest {

    val fakeNetworkDataSource = FakeNetworkDataSource()
    val homeFeedRepository = ImplHomeFeedRepository(fakeNetworkDataSource)

    @Test
    fun `when requested stories, will return populated list of stories`() {
        val expectedData = fakeNetworkDataSource.fakeStories


        val actualData =  homeFeedRepository.fetchStories()

        assert(expectedData == actualData)
    }


}