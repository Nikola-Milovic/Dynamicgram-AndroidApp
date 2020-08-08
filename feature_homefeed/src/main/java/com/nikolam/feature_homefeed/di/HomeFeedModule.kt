package com.nikolam.feature_homefeed.di



import com.nikolam.core.di.scope.HomeFeedScope
import com.nikolam.core.di.ui.getViewModel
import com.nikolam.feature_homefeed.data.ImplHomeFeedRepository
import com.nikolam.feature_homefeed.data.network.NetworkDataSource
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import com.nikolam.feature_homefeed.ui.HomeFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module()
class HomeFeedModule(private val fragment : HomeFeedFragment){

    @Provides
    @HomeFeedScope
    fun provideNetworkDataSource() : NetworkDataSource = NetworkDataSource()

    @Provides
    fun homeFeedViewModel(homeFeedRepository: ImplHomeFeedRepository): HomeFeedViewModel =
        fragment.getViewModel {
            HomeFeedViewModel(homeFeedRepository)
        }

    @Provides
    @HomeFeedScope
    fun providesHomeFeedRepository(networkDataSource: NetworkDataSource) : ImplHomeFeedRepository {
        return ImplHomeFeedRepository(networkDataSource)
    }

}