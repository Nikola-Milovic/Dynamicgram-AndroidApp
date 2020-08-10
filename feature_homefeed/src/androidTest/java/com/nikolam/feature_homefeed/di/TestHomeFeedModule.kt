package com.nikolam.feature_homefeed.di

import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.core.di.ui.getViewModel
import com.nikolam.feature_homefeed.data.IhomeFeedRepository
import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.data.INetworkDataSource
import com.nikolam.feature_homefeed.di.data.FakeNetworkDataSource
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Module
import dagger.Provides

@Module()
class TestHomeFeedModule(private val fragment : HomeFeedFragment){

    @FragmentScope
    @Provides
    fun provideNetworkDataSource() : INetworkDataSource =
        FakeNetworkDataSource()

    @FragmentScope
    @Provides
    fun homeFeedViewModel(homeFeedRepository: IhomeFeedRepository): HomeFeedViewModel =
        fragment.getViewModel {
            HomeFeedViewModel(homeFeedRepository)
        }

    @FragmentScope
    @Provides
    fun providesHomeFeedRepository(networkDataSource: INetworkDataSource) : IhomeFeedRepository {
        return ImplHomeFeedRepository(networkDataSource)
    }

}
