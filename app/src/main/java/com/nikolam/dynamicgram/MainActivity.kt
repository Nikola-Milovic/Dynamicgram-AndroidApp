package com.nikolam.dynamicgram

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
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

     //   setupBottomNavigation()

    }
//
//    private fun setupBottomNavigation() {
//        val navController = findNavController(R.id.nav_host_fragment)
//            .setupWithNavController(navController)
//    }
}

//    <com.google.android.material.bottomnavigation.BottomNavigationView
//        android:id="@+id/bottomNav"
//        style="@style/Widget.MaterialComponents.BottomNavigationView.Colored"
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:layout_gravity="bottom"
//        android:background="@color/colorPrimary"
//        app:labelVisibilityMode="labeled"
//        app:layout_constraintBottom_toBottomOf="parent"
//        app:layout_constraintHorizontal_bias="1.0"
//        app:layout_constraintLeft_toLeftOf="parent"
//        app:layout_constraintRight_toRightOf="parent"
//        app:layout_constraintTop_toBottomOf="@id/nav_host_fragment"
//        app:layout_constraintVertical_bias="1.0"
//        app:menu="@menu/bottom_nav_menu" />