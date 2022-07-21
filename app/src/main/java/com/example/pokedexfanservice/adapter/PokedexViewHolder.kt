package com.example.pokedexfanservice.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.view.OnPokedexListener

class PokedexViewHolder(internal val binding: RowBinding, private val listener: OnPokedexListener) : RecyclerView.ViewHolder(binding.root) {


    fun bind(pkm : PokemonModel){

        binding.imagePokemonSprite.setOnClickListener {
            listener.onClick(pkm)

        }



    }

}