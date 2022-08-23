package com.example.pokedexfanservice.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokedexfanservice.adapter.PokedexAdapter
import com.example.pokedexfanservice.databinding.ActivityPokedexBinding
import com.example.pokedexfanservice.viewmodel.PokemonViewModel


class PokedexActivityView() : AppCompatActivity() {

    private lateinit var binding: ActivityPokedexBinding
    private lateinit var viewModel: PokemonViewModel
    private val customLayoutManager = GridLayoutManager(this,3)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)
        binding = ActivityPokedexBinding.inflate(layoutInflater)
        binding.recyclerListPokemon.layoutManager = customLayoutManager
        binding.recyclerListPokemon.adapter = PokedexAdapter(viewModel.getAll())

        setContentView(binding.root)
        supportActionBar?.hide()

    }

}