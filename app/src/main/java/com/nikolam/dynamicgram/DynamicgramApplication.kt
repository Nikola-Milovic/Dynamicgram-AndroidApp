package com.nikolam.dynamicgram

import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.nikolam.core.di.ContextModule
import com.nikolam.core.di.CoreComponent
import com.nikolam.core.di.CoreComponentProvider
import com.nikolam.core.di.DaggerCoreComponent
import timber.log.Timber

class DynamicgramApplication : SplitCompatApplication(), CoreComponentProvider {

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

        initLogging()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun provideCoreComponent(): CoreComponent = coreComponent
}
