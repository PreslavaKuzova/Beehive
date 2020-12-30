package com.example.beehive

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.beehive.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViews()
    }

    private fun setupViews() {
        // Finding the Navigation Controller
        val navController =  findNavController(R.id.nav_host_fragment)

        // Setting Navigation Controller with the BottomNavigationView
        binding.bottomNav.setupWithNavController(navController)
    }
}