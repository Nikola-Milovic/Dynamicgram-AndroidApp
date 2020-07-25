package com.nikolam.dynamicgram

import com.google.android.play.core.splitcompat.SplitCompatApplication
import timber.log.Timber

class DynamicgramApplication  : SplitCompatApplication(){

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}