package com.nikolam.feature_homefeed.di

import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [],
    dependencies = [CoreComponent::class]
)
interface HomeFeedComponent {
    fun inject(homeFeedFragment: HomeFeedFragment)
}