package com.example.pokedexfanservice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexfanservice.databinding.RowBinding
import com.example.pokedexfanservice.model.PokemonModel
import com.example.pokedexfanservice.view.OnPokedexListener


class PokedexAdapter : RecyclerView.Adapter<PokedexViewHolder>() {

    var listPokedex: List<PokemonModel> = listOf()
    lateinit var listener: OnPokedexListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {

        val item = RowBinding.inflate(LayoutInflater.from(parent.context))
        return PokedexViewHolder(item, listener)

    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {

        val pokemonModel = listPokedex[position]
        val urlFront = pokemonModel.sprites.front_default
        val imageView = holder.binding.imagePokemonSprite


        holder.bind(pokemonModel)
        Glide.with(imageView).load(urlFront).into(imageView)

    }


    override fun getItemCount(): Int {
        return listPokedex.size
    }

    fun updateList(listDB: List<PokemonModel>) {
        listPokedex = listDB

    }

    fun attachListener(listenerReceived: OnPokedexListener){
        listener = listenerReceived
    }



}