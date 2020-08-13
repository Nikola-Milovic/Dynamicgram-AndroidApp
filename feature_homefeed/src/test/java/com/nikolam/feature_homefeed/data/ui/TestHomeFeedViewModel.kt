package com.nikolam.feature_homefeed.di.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nikolam.feature_homefeed.data.network.FakeHomeFeedRepsitory
import com.nikolam.feature_homefeed.data.model.fakePosts
import com.nikolam.feature_homefeed.data.model.fakeStories
import com.nikolam.feature_homefeed.data.util.getOrAwaitValue
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test


open class TestHomeFeedViewModel (){

    @Rule
    @JvmField //needs to be added as in kotlin Junit complains that rule has to be public
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    val fakeRepsitory = FakeHomeFeedRepsitory()
    val viewmodel = HomeFeedViewModel(fakeRepsitory)

    @Before
    fun setup(){

    }

    @Test
    fun `will populate livedata with correct values from the repository`() {

        val expectedStories = fakeStories
        val expectedPosts = fakePosts
        viewmodel.makeAList()

        assert(expectedStories == viewmodel.storyListLiveData.getOrAwaitValue())
        assert(expectedPosts == viewmodel.postListLiveData.getOrAwaitValue())
    }

}
