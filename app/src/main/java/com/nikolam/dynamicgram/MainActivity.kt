package com.nikolam.dynamicgram

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nikolam.core.ui.extensions.coreComponent
import com.nikolam.dynamicgram.di.DaggerMainActivityComponent
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    val layoutResId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencyInjection()

        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        supportActionBar?.hide()

        // The window will not be resized when virtual keyboard is shown (bottom navigation bar will be
        // hidden under virtual keyboard)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

        Timber.v("onCreate ${javaClass.simpleName}")

        setupBottomNavigation()
    }

    private fun initDependencyInjection() =
        DaggerMainActivityComponent
            .builder()
            .coreComponent(coreComponent())
            .build()
            .inject(this)

    private fun setupBottomNavigation() {
        val navController = findViewById<View>(R.id.nav_host_fragment).findNavController()
        findViewById<BottomNavigationView>(R.id.bottomNav).setupWithNavController(navController)
    }
}
