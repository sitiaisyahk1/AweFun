package com.keinat.awefun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.keinat.awefun.utils.onNavDestinationSelected
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        bubbleTabBar.addBubbleListener{ id ->
            onNavDestinationSelected(id, navController)

        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            bubbleTabBar.setSelectedWithId(destination.id, false)
        }

    }
}

// !! bang operator (maksa harus ga null kalau ga null bakal force close)
// ?: elvis operator (kalau misal ini null pakai ini).
// ? opsional