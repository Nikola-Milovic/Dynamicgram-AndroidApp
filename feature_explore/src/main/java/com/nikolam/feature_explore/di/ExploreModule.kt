package com.nikolam.feature_homefeed.di



import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.core.di.ui.getViewModel
import com.nikolam.feature_explore.data.IExploreRepository
import com.nikolam.feature_explore.data.ImplExploreRepository
import com.nikolam.feature_explore.data.network.INetworkDataSource
import com.nikolam.feature_explore.ui.ExploreFragment
import com.nikolam.feature_explore.ui.ExploreViewModel
import dagger.Module
import dagger.Provides


@Module()
class ExploreModule(private val fragment : ExploreFragment){

    @FragmentScope
    @Provides
    fun homeFeedViewModel(homeFeedRepository: IExploreRepository): ExploreViewModel =
        fragment.getViewModel {
            ExploreViewModel(homeFeedRepository)
        }

    @FragmentScope
    @Provides
    fun providesExploreRepository(networkDataSource: INetworkDataSource) : IExploreRepository {
        return ImplExploreRepository(networkDataSource)
    }

}
