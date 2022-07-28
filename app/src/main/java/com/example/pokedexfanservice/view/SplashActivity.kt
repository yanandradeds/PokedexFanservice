package com.example.pokedexfanservice.view

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.pokedexfanservice.databinding.ActivitySplashBinding
import com.example.pokedexfanservice.viewmodel.PokemonViewModel

class SplashActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySplashBinding
    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonViewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        supportActionBar!!.hide()


        startActivity(Intent(this,MainActivityView::class.java))
        finish()

    }


}


