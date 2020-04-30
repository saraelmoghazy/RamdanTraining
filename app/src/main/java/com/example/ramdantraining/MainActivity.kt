package com.example.ramdantraining

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigationController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupBottomNav(navigationController)
    }

    private fun setupBottomNav(navigationController: NavController) {
        bottom_nav?.let { NavigationUI.setupWithNavController(it, navigationController) }

    }
}