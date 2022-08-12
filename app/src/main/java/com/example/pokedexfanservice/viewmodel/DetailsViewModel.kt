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

        Glide.with(viewImagePrincipal).load(sprite.officialArtworkFront).into(viewImagePrincipal)

        

        binding.textPokemonId.text = when {
            pokemon.id < 10 -> "00${pokemon.id}"
            pokemon.id < 100 -> "0${pokemon.id}"
            else -> "#${pokemon.id}"
        }


        binding.textPokemonName.text = pokemon.name.replaceFirstChar { it.uppercase() }

    }



    fun setTypeImage(imageView: ImageView, pokemon: PokemonModel, secondType: Boolean) {

        val type: String? =
            if(secondType) pokemon.type2
            else pokemon.type


        when (type) {

            "grass" -> imageView.setImageResource(TypeImageConstants.GRASS)
            "poison" -> imageView.setImageResource(TypeImageConstants.POISON)
            "fire" -> imageView.setImageResource(TypeImageConstants.FIRE)
            "ice" -> imageView.setImageResource(TypeImageConstants.ICE)
            "electric" -> imageView.setImageResource(TypeImageConstants.ELECTRIC)
            "steel" -> imageView.setImageResource(TypeImageConstants.STEEL)
            "water" -> imageView.setImageResource(TypeImageConstants.WATER)
            "dark" -> imageView.setImageResource(TypeImageConstants.DARK)
            "ghost" -> imageView.setImageResource(TypeImageConstants.GHOST)
            "normal" -> imageView.setImageResource(TypeImageConstants.NORMAL)
            "dragon" -> imageView.setImageResource(TypeImageConstants.DRAGON)
            "fighting" -> imageView.setImageResource(TypeImageConstants.FIGHTING)
            "flying" -> imageView.setImageResource(TypeImageConstants.FLYING)
            "fairy" -> imageView.setImageResource(TypeImageConstants.FAIRY)
            "ground" -> imageView.setImageResource(TypeImageConstants.GROUND)
            "rock" -> imageView.setImageResource(TypeImageConstants.ROCK)
            "bug" -> imageView.setImageResource(TypeImageConstants.BUG)
            "psychic" -> imageView.setImageResource(TypeImageConstants.PSYCHIC)
            null -> return

        }

    }



}

