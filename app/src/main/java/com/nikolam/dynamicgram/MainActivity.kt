package com.nikolam.dynamicgram

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    val layoutResId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layoutResId)

        supportActionBar?.hide()

        // The window will not be resized when virtual keyboard is shown (bottom navigation bar will be
        // hidden under virtual keyboard)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING)

        Timber.v("onCreate ${javaClass.simpleName}")

        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        val navController = findViewById<View>(R.id.nav_host_fragment).findNavController()
        findViewById<BottomNavigationView>(R.id.bottomNav).setupWithNavController(navController)
    }
}

