package com.nikolam.dynamicgram

import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(
    modules = [TestActivityModule::class],
    dependencies = [CoreComponent::class]
)
interface TestMainActivityComponent {
    fun inject(mainActivity: MainActivity)
}
