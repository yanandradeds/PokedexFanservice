package com.example.pokedexfanservice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.model.SpriteModel
import com.example.pokedexfanservice.listener.CustomListener

class PokedexViewHolder(internal val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {

    fun setListener(pokemon : PokemonModel, sprite: SpriteModel, listener: CustomListener){

        binding.imagePokemonSprite.setOnClickListener {

            listener.onClick(sprite,pokemon)

        }

    }

}