package com.example.pokedexfanservice.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexfanservice.adapter.PokedexAdapter
import com.example.pokedexfanservice.databinding.ActivityMainBinding
import com.example.pokedexfanservice.listener.CustomListener
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.viewmodel.PokemonViewModel


class MainActivityView() : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PokemonViewModel
    private val adapterClass = PokedexAdapter()
    private val customLayoutManager = GridLayoutManager(this,4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        supportActionBar?.hide()

        //Parametros padrão da RecycleView

        binding.recyclerUnique.layoutManager = customLayoutManager
        binding.recyclerUnique.adapter = adapterClass


        adapterClass.updateLists(viewModel.getAllPokemonModel(),viewModel.getAllSpriteModel())


    }
    


}