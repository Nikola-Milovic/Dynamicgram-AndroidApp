package com.nikolam.dynamicgram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Observer
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import kotlinx.android.synthetic.main.activity_main.*
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
        val navController = navHostFragment.findNavController()
        bottomNav.setupWithNavController(navController)

//        bottomNav.setOnNavigationItemReselectedListener { item ->
//            when(item.itemId) {
//                R.id.homefeed_item -> {
//                    navController.navigate(R.id.homeFeed)
//                }
//                R.id.exploration_item -> {
//                    navController.navigate(R.id.exploreFragment2)
//                }
//            }
//        }

//        val installMonitor = DynamicInstallMonitor()
//        if (installMonitor.isInstallRequired) {
//            installMonitor.status.observe(this, object : Observer<SplitInstallSessionState> {
//                override fun onChanged(sessionState: SplitInstallSessionState) {
//                    when (sessionState.status()) {
//                        SplitInstallSessionStatus.INSTALLED -> {
//                            // Call navigate again here or after user taps again in the UI:
//                            // navController.navigate(destinationId, destinationArgs, null, null)
//                        }
//                        SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
//                          //  SplitInstallManager.startConfirmationDialogForResult(...)
//                        }
//
//                        // Handle all remaining states:
//                        SplitInstallSessionStatus.FAILED -> {}
//                        SplitInstallSessionStatus.CANCELED -> {}
//                    }
//
//                    if (sessionState.hasTerminalStatus()) {
//                        installMonitor.status.removeObserver(this);
//                    }
//                }
//            });
       // }
    }
}