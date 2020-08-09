package com.nikolam.feature_homefeed.di



import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.core.di.ui.getViewModel
import com.nikolam.feature_homefeed.data.IhomeFeedRepository
import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.network.INetworkDataSource
import com.nikolam.feature_homefeed.data.network.NetworkDataSource
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Module
import dagger.Provides


@Module()
class HomeFeedModule(private val fragment : HomeFeedFragment){

    @FragmentScope
    @Provides
    fun provideNetworkDataSource() : INetworkDataSource = NetworkDataSource()

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