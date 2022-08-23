package com.example.pokedexfanservice.viewmodel

import android.annotation.SuppressLint
import android.content.res.Resources
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.pokedexfanservice.constants.BackgroundColorByType
import com.example.pokedexfanservice.constants.TypeImageConstants
import com.example.pokedexfanservice.databinding.ActivityDetailsViewBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel

class DetailsViewModel: ViewModel() {



    fun holderStyle(binding: ActivityDetailsViewBinding, pokemon: PokemonModel, sprite : SpriteModel) {

        val viewImagePrincipal = binding.imagePrincipal



        

        binding.textPokemonId.text = when {
            pokemon.id < 10 -> "00${pokemon.id}"
            pokemon.id < 100 -> "0${pokemon.id}"
            else -> "#${pokemon.id}"
        }


        binding.textPokemonName.text = pokemon.name.replaceFirstChar { it.uppercase() }

    }



    fun setTypeImage(imageView: ImageView, pokemon: PokemonModel, secondType: Boolean) {



    }



}

