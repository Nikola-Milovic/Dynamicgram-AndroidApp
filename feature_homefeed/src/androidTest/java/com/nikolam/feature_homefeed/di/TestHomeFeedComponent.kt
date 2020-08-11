package com.nikolam.feature_homefeed.di

import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.FragmentScope
import com.nikolam.feature_homefeed.di.HomeFeedModule
import com.nikolam.feature_homefeed.ui.HomeFeedFragment
import dagger.Component

@FragmentScope
@Component(
    modules = [HomeFeedModule::class],
    dependencies = [CoreComponent::class]
)
interface TestHomeFeedComponent {

    fun inject(fragment: HomeFeedFragment)

}

///   @Before public void setUp() {
//        TestComponent component = DaggerTestComponent.builder()
//            .myModule(new TestModule()).build();
//        component.inject(this);
//    }
