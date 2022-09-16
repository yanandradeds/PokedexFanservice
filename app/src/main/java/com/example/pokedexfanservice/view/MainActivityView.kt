package com.example.pokedexfanservice.view

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pokedexfanservice.R
import com.example.pokedexfanservice.database.PokedexDatabase
import com.example.pokedexfanservice.databinding.ActivityMainViewBinding

import com.example.pokedexfanservice.viewmodel.MainActivityViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenuView
import com.google.android.material.navigation.NavigationBarView


class MainActivityView() : AppCompatActivity(){

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        supportActionBar?.hide()

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        val navController = navHost.navController

        navView.setupWithNavController(navController)

        navView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.pokedexFragment -> navController.navigate(R.id.pokedexFragmentView)
                R.id.typesFragment -> navController.navigate(R.id.typesFragmentView)
                else -> navController.navigate(R.id.detailsFragmentView)
            }

            true
        }

    }

}